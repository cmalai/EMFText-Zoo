package org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.analysis;

public class ConnectionTargetReferenceResolver implements org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.IRailsTgg_ruleReferenceResolver<org.emftext.language.rails.Connection, org.emftext.language.rails.In> {
	
	private org.emftext.language.rails.resource.rails.analysis.ConnectionTargetReferenceResolver delegate = new org.emftext.language.rails.resource.rails.analysis.ConnectionTargetReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rails.Connection container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.IRailsTgg_ruleReferenceResolveResult<org.emftext.language.rails.In> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.rails.resource.rails.IRailsReferenceResolveResult<org.emftext.language.rails.In>() {
			
			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}
			
			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}
			
			public boolean wasResolved() {
				return result.wasResolved();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public java.util.Collection<org.emftext.language.rails.resource.rails.IRailsReferenceMapping<org.emftext.language.rails.In>> getMappings() {
				throw new UnsupportedOperationException();
			}
			
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}
			
			public void addMapping(String identifier, org.emftext.language.rails.In target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.rails.In target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.rails.In element, org.emftext.language.rails.Connection container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
