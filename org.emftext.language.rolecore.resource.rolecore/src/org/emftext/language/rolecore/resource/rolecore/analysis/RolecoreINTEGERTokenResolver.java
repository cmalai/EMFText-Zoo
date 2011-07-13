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
package org.emftext.language.rolecore.resource.rolecore.analysis;

public class RolecoreINTEGERTokenResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolver {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value instanceof Integer) {
			Integer intValue = (Integer) value;
			if (intValue.intValue() == -1) {
				return "*";
			}
		}
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolveResult result) {
		if ("*".equals(lexem)) {
			result.setResolvedToken(-1);
		} else {
			defaultTokenResolver.resolve(lexem, feature, result);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
