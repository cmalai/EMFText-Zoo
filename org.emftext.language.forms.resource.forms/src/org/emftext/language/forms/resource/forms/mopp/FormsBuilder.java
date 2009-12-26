/*******************************************************************************
 * Copyright (c) 2006-2009 
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

package org.emftext.language.forms.resource.forms.mopp;

import org.emftext.language.forms.resource.forms.custom.GeneratingResourceProcessor;

public class FormsBuilder implements org.emftext.language.forms.resource.forms.IFormsBuilder {
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.forms.resource.forms.mopp.FormsResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		new GeneratingResourceProcessor().process(resource.getContents());
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}