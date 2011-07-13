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
package org.emftext.language.java.properties.java2dsl.qvto;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.resource.java.IJavaBuilder;
import org.emftext.language.java.resource.java.mopp.JavaBuilderAdapter;
import org.emftext.language.java.resource.java.mopp.JavaResource;


public class QVTOJavaToPropertyBuilder 
	extends JavaBuilderAdapter 
	implements IJavaBuilder {

	private QVTOJava2PropertyBuildAdapter myAdapter = new QVTOJava2PropertyBuildAdapter();
	
	public boolean isBuildingNeeded(URI uri) {
		
		return myAdapter.isBuildingNeeded(uri);
	}
	
	public IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		
		return build(kind, args, monitor, this, getProject()); 
	}
	
	public IStatus build(final JavaResource resource, IProgressMonitor monitor) {
		
		return myAdapter.build(resource, monitor);
	}
}
