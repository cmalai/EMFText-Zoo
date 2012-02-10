/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.language.hedl.resource.hedl.mopp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.EntityModel;
import org.emftext.language.hedl.codegen.HEDLCodegenConstants;
import org.emftext.language.hedl.codegen.HEDLGenerator;
import org.emftext.language.hedl.codegen.ImportsOrganizer;
import org.emftext.language.hedl.resource.hedl.IHedlBuilder;
import org.emftext.language.hedl.resource.hedl.util.HedlStringUtil;

public class HedlBuilder implements IHedlBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return !isInBinFolder(uri);
	}
	
	public IStatus build(HedlResource resource, IProgressMonitor monitor) {
		// do not build resources that contain errors
		if (!resource.getErrors().isEmpty()) {
			return Status.CANCEL_STATUS;
		}
		
		URI uri = resource.getURI();
		String packageName = getPackageName(uri);
		IFile modelFile = WorkspaceSynchronizer.getFile(resource);
		IContainer modelFolder = modelFile.getParent();
		File modelFolderFile = modelFolder.getRawLocation().toFile();
		File daoFolder = new File(modelFolderFile, HEDLCodegenConstants.DAO_PACKAGE_NAME);
		daoFolder.mkdirs();
		File entitiesFolder = new File(modelFolderFile, HEDLCodegenConstants.ENTITY_PACKAGE_NAME);
		entitiesFolder.mkdirs();
		File customFolder = new File(modelFolderFile, HEDLCodegenConstants.CUSTOM_PACKAGE_NAME);
		customFolder.mkdirs();
		String mainDAOClassname = resource.getURI().trimFileExtension().lastSegment() + "DAO";
		String mainDAOBaseClassname = mainDAOClassname + "Base";

		int loc = 0;
		HEDLGenerator generator = new HEDLGenerator();
		// set option overrideBuilder to 'false' and then perform build here
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Entity) {
				Entity entity = (Entity) next;
				// generate entity base class
				CharSequence result = generator.generateEntityBaseClass(packageName, entity);
				loc += saveGeneratedClass(entitiesFolder, result, entity.getName());
				// generate entity DAO class
				result = generator.generateEntityDAO(packageName, entity);
				loc += saveGeneratedClass(daoFolder, result, entity.getName() + "DAO");
			} else if (next instanceof org.emftext.language.hedl.Enum) {
				org.emftext.language.hedl.Enum enumeration = (org.emftext.language.hedl.Enum) next;
				// generate enum class
				CharSequence result = generator.generateEnum(packageName, enumeration);
				loc += saveGeneratedClass(entitiesFolder, result, enumeration.getName());
			} else if (next instanceof EntityModel) {
				EntityModel entityModel = (EntityModel) next;
				CharSequence result = generator.generateIDBOperationsBase(packageName, entityModel);
				loc += saveGeneratedClass(daoFolder, result, "IDBOperationsBase");
				result = generator.generateIDBOperations(packageName);
				loc += saveGeneratedClass(customFolder, result, "IDBOperations", false);
				result = generator.generateICommand(packageName);
				loc += saveGeneratedClass(daoFolder, result, "ICommand");
				result = generator.generateOperationProviderBase(packageName, entityModel);
				loc += saveGeneratedClass(daoFolder, result, "OperationProviderBase");
				result = generator.generateOperationProvider(packageName);
				loc += saveGeneratedClass(customFolder, result, "OperationProvider", false);
				result = generator.generateMainDAO(packageName, mainDAOClassname);
				loc += saveGeneratedClass(customFolder, result, mainDAOClassname, false);
				result = generator.generateMainDAOBase(packageName, mainDAOBaseClassname, entityModel);
				loc += saveGeneratedClass(daoFolder, result, mainDAOBaseClassname);
				result = generator.generateOngoingShutdownException(packageName);
				loc += saveGeneratedClass(daoFolder, result, "OngoingShutdownException");
			}
		}
		
		try {
			modelFolder.refreshLocal(IFile.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// ignore
		}
		
		if (modelFolder instanceof IFolder) {
			new ImportsOrganizer().organize((IFolder) modelFolder);
		}
		logInfo("Generated lines of code: " + loc);
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private int saveGeneratedClass(File modelFolderFile, CharSequence content,
			String classname) {
		return saveGeneratedClass(modelFolderFile, content, classname, true);
	}
	
	private int saveGeneratedClass(File modelFolderFile, CharSequence content,
			String classname, boolean override) {
		int loc = 0;
		File entityClassFile = new File(modelFolderFile, classname + ".java");
		if (entityClassFile.exists() && !override) {
			return loc;
		}
		try {
			FileOutputStream fos = new FileOutputStream(entityClassFile);
			String text = content.toString();
			loc = text.split("(\\n|\\r)+").length;
			fos.write(text.getBytes());
			fos.close();
		} catch (IOException e) {
			HedlPlugin.logError("Excpetion while generating code.", e);
		}
		return loc;
	}

	private String getPackageName(URI uri) {
		String packageName = new String();
		String[] segments = uri.trimFileExtension().trimSegments(1).segments();
		List<String> packages = new ArrayList<String>();
		for (int i = segments.length - 1; i >= 0; i--) {
			String segment = segments[i];
			if (isSourceFolder(segment)) {
				break;
			}
			packages.add(0, segment);
		}
		packageName = HedlStringUtil.explode(packages, ".");
		return packageName;
	}

	private boolean isSourceFolder(String segment) {
		return segment.startsWith("src");
	}

	private void logInfo(String message) {
		IStatus status = new Status(IStatus.INFO, HedlPlugin.PLUGIN_ID, message);
		HedlPlugin pluginInstance = HedlPlugin.getDefault();
		if (pluginInstance != null) {
			pluginInstance.getLog().log(status);
		}
	}

	private boolean isInBinFolder(URI uri) {
		String[] segments = uri.segments();
		for (String segment : segments) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
