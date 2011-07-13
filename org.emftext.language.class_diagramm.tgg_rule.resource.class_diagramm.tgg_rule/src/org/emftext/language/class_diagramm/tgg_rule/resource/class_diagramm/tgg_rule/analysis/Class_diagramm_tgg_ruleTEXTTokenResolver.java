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
package org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis;

public class Class_diagramm_tgg_ruleTEXTTokenResolver implements org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleTokenResolver {
	
	private org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis.Class_diagramm_tgg_ruleDefaultTokenResolver defaultTokenResolver = new org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis.Class_diagramm_tgg_ruleDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
