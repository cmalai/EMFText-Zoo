/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.properties.java2dsl.qvto;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.properties.resource.propjava.IPropjavaBuilder;
import org.emftext.language.java.properties.resource.propjava.mopp.PropjavaBuilderAdapter;
import org.emftext.language.java.properties.resource.propjava.mopp.PropjavaResource;


public class QVTOPropertyToJavaBuilder 
	extends PropjavaBuilderAdapter 
	implements IPropjavaBuilder {

	private QVTOJava2PropertyBuildAdapter myAdapter = new QVTOJava2PropertyBuildAdapter();
		
	public boolean isBuildingNeeded(URI uri) {
		
		return myAdapter.isBuildingNeeded(uri);
	}
	
	public IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		
		return build(kind, args, monitor, this, getProject()); 
	}
	
	public IStatus build(final PropjavaResource resource, IProgressMonitor monitor) {
		
		return myAdapter.build(resource, monitor);
	}
}
