/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.resource.jdt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.emftext.language.java.JavaClasspath;

public class JDTConnector implements JavaClasspath.Initializer {

	public void initialize(Resource resource) {
		initializeResourceSet(resource.getResourceSet(), resource.getURI());
	}
	
	public boolean requiresLocalClasspath() {
		return true;
	}
	
	public boolean requiresStdLib() {
		return false;
	}
	
	private boolean isJavaProject(IProject project) {
		if (project == null) {
			return false;
		}
		try {
			return project.isNatureEnabled("org.eclipse.jdt.core.javanature");
		} catch (CoreException e) {
		}
		return false;
	}

	private IProject getProject(URI uri) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (uri.isPlatformResource() && uri.segmentCount() > 2) {
			return root.getProject(uri.segment(1));
		}
		return null;
	}
	
	private IJavaProject getJavaProject(IProject project) {
		return (isJavaProject(project) ? JavaCore.create(project) : null);
	}
	
	private void initializeResourceSet(ResourceSet resourceSet, URI resourceURI) {
		if (resourceSet == null) {
			return;
		}
		if (resourceSet.getURIConverter() == null) {
			return;
		}
		if (!resourceSet.getURIConverter().normalize(resourceURI)
				.isPlatformResource()) {
			return;
		}

		if (resourceURI != null) {
			IJavaProject javaProject = getJavaProject(getProject(resourceURI));
			registerJavaProjectInClassPath(resourceSet, javaProject);
		}
	}

	private void registerJavaProjectInClassPath(
			final ResourceSet resourceSet,
			final IJavaProject javaProject) {

		SearchEngine searchEngine = new SearchEngine();
		
		try {
			searchEngine.searchAllTypeNames(null, null, 
					SearchEngine.createJavaSearchScope(new IJavaProject[] {javaProject}), 
					new ClasspathFiller(JavaClasspath.get(resourceSet)), IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);
		} catch (JavaModelException e) { 
			log("Problem building classpath", e);
		}
	}

	private void log(String msg, JavaModelException e) {
		ResourcesPlugin.getPlugin().getLog().log(new 
				Status(IStatus.WARNING, "org.emftext.language.java", "[JaMoPP] " + msg, e));
	}	

	private static final class ClasspathFiller extends TypeNameRequestor {
		private final JavaClasspath classPath;

		private ClasspathFiller(JavaClasspath classPath) {
			this.classPath = classPath;
		}

		@Override
		public void acceptType(int modifiers,
				char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			
			String filePath = null;
			String inArchivePath = null;
			if (path.contains(".jar|")) {
				String[] split = path.split("\\|");
				filePath = split[0];
				inArchivePath = split[1];
			} else {
				filePath = path;
			}
			
			URI uri;
			if (isInWorkspace(filePath)) {
				if (inArchivePath != null) {
					uri = URI.createURI("archive:" + URI.createPlatformResourceURI(filePath, true) + "!/" + inArchivePath);
				} else {
					uri = URI.createPlatformResourceURI(filePath, true);
				}		
			} else {
				if (inArchivePath != null) {
					uri = URI.createURI("archive:" + URI.createFileURI(filePath).toString() + "!/" + inArchivePath);
				} else {
					uri = URI.createFileURI(filePath);
				}
			}

			String fullContainerName = String.valueOf(packageName) + ".";
			for (char[] enclosingType : enclosingTypeNames) {
				fullContainerName = fullContainerName + String.valueOf(enclosingType) + "$";
			}
			
			classPath.registerClassifier(
					fullContainerName, 
					String.valueOf(simpleTypeName), uri);			
		}
		
		private boolean isInWorkspace(String path) {
			IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
			return wsRoot.findMember(path) != null;
		}
	}
}