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
package org.emftext.language.km3.resource.km3.analysis;

import java.util.Map;

import org.emftext.language.km3.resource.km3.IKm3ReferenceResolveResult;
import org.emftext.language.km3.resource.km3.IKm3ReferenceResolver;

public class TypedElementTypeReferenceResolver implements IKm3ReferenceResolver<org.eclipse.gmt.am3.dsls.KM3.TypedElement, org.eclipse.gmt.am3.dsls.KM3.Classifier> {

	private Km3DefaultResolverDelegate<org.eclipse.gmt.am3.dsls.KM3.TypedElement, org.eclipse.gmt.am3.dsls.KM3.Classifier> delegate = new Km3DefaultResolverDelegate<org.eclipse.gmt.am3.dsls.KM3.TypedElement, org.eclipse.gmt.am3.dsls.KM3.Classifier>();

	public java.lang.String deResolve(org.eclipse.gmt.am3.dsls.KM3.Classifier element, org.eclipse.gmt.am3.dsls.KM3.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void resolve(java.lang.String identifier, org.eclipse.gmt.am3.dsls.KM3.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IKm3ReferenceResolveResult<org.eclipse.gmt.am3.dsls.KM3.Classifier> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
