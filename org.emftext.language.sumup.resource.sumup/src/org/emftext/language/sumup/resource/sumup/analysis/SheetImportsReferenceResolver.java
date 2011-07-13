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
package org.emftext.language.sumup.resource.sumup.analysis;

public class SheetImportsReferenceResolver implements org.emftext.language.sumup.resource.sumup.ISumupReferenceResolver<org.emftext.language.sumup.Sheet, org.emftext.language.sumup.Sheet> {
	
	private org.emftext.language.sumup.resource.sumup.analysis.SumupDefaultResolverDelegate<org.emftext.language.sumup.Sheet, org.emftext.language.sumup.Sheet> delegate = new org.emftext.language.sumup.resource.sumup.analysis.SumupDefaultResolverDelegate<org.emftext.language.sumup.Sheet, org.emftext.language.sumup.Sheet>();
	
	public void resolve(String identifier, org.emftext.language.sumup.Sheet container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.sumup.resource.sumup.ISumupReferenceResolveResult<org.emftext.language.sumup.Sheet> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.sumup.Sheet element, org.emftext.language.sumup.Sheet container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toString();
		//return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
