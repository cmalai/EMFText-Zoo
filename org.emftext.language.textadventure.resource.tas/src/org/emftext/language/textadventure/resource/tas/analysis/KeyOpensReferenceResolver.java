package org.emftext.language.textadventure.resource.tas.analysis;

import org.emftext.language.textadventure.resource.tas.ITasReferenceResolveResult;
import org.emftext.language.textadventure.resource.tas.ITasReferenceResolver;

public class KeyOpensReferenceResolver implements ITasReferenceResolver<org.emftext.language.textadventure.Key, org.emftext.language.textadventure.Door> {
	
	private org.emftext.language.textadventure.resource.tas.analysis.TasDefaultResolverDelegate<org.emftext.language.textadventure.Key, org.emftext.language.textadventure.Door> delegate = new org.emftext.language.textadventure.resource.tas.analysis.TasDefaultResolverDelegate<org.emftext.language.textadventure.Key, org.emftext.language.textadventure.Door>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.textadventure.Key container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITasReferenceResolveResult<org.emftext.language.textadventure.Door> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.textadventure.Door element, org.emftext.language.textadventure.Key container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
