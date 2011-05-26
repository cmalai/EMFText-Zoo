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
package org.emftext.language.statemachine.resource.statemachine.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.language.statemachine.resource.statemachine.IStatemachineReferenceResolveResult;
import org.emftext.language.statemachine.resource.statemachine.IStatemachineReferenceResolver;

public class TransitionTargetReferenceResolver implements
	IStatemachineReferenceResolver<Transition, Vertex> {

	public java.lang.String deResolve(Vertex element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void resolve(String identifier, Transition container, EReference reference, int position, boolean resolveFuzzy, IStatemachineReferenceResolveResult<Vertex> result) {
		for (Vertex targetCand : container.getContainer().getSubvertices()) {
			if (identifier.equals(targetCand.getName()) || resolveFuzzy) {
				result.addMapping(targetCand.getName(), targetCand);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
