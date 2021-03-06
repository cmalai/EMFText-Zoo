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
package org.emftext.language.xml.resource.xml.analysis;

import org.emftext.language.xml.resource.xml.IXmlReferenceResolveResult;
import org.emftext.language.xml.resource.xml.IXmlReferenceResolver;

public class NodeEndReferenceResolver implements IXmlReferenceResolver<org.emftext.language.exml.Node, org.emftext.language.exml.Tag> {

	private org.emftext.language.xml.resource.xml.analysis.XmlDefaultResolverDelegate<org.emftext.language.exml.Node, org.emftext.language.exml.Tag> delegate = new org.emftext.language.xml.resource.xml.analysis.XmlDefaultResolverDelegate<org.emftext.language.exml.Node, org.emftext.language.exml.Tag>();

	public void resolve(java.lang.String identifier, org.emftext.language.exml.Node container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IXmlReferenceResolveResult<org.emftext.language.exml.Tag> result) {
		if (container.getStart().getName().equals(identifier)) {
			result.addMapping(identifier, container.getStart());
		}
		if (resolveFuzzy) {
			result.addMapping(container.getStart().getName(), container.getStart());
		}
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.exml.Tag element, org.emftext.language.exml.Node container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
