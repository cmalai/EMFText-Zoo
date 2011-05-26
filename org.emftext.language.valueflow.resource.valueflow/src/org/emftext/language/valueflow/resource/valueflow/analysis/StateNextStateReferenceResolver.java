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
package org.emftext.language.valueflow.resource.valueflow.analysis;

import java.util.Map;

import org.emftext.language.valueflow.resource.valueflow.ITextValueflowReferenceResolveResult;
import org.emftext.language.valueflow.resource.valueflow.ITextValueflowReferenceResolver;

public class StateNextStateReferenceResolver implements ITextValueflowReferenceResolver<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> {

	private TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> delegate = new TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State>();

	public java.lang.String deResolve(org.emftext.language.valueflow.State element, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void resolve(java.lang.String identifier, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITextValueflowReferenceResolveResult<org.emftext.language.valueflow.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
