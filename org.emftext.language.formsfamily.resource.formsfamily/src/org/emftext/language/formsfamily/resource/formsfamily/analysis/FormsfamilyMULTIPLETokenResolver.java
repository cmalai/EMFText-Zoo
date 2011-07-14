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
package org.emftext.language.formsfamily.resource.formsfamily.analysis;

import org.emftext.language.formsfamily.resource.formsfamily.analysis.helper.BooleanAttributeResolver;

public class FormsfamilyMULTIPLETokenResolver implements org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyTokenResolver {
	
	private BooleanAttributeResolver defaultTokenResolver = new BooleanAttributeResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
	
}