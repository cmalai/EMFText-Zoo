/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.language.usecaseinvariant.resource.ucinv.analysis;

import java.util.Map;

public class UcinvT_INCLUDINGTokenResolver implements org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (Boolean.TRUE.equals(value)) {
			return "set including";
		}
		return "";
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvTokenResolveResult result) {
		result.setResolvedToken(true);
	}

	public void setOptions(Map<?, ?> options) {}
	
}