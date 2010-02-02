/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.database.tgg_rule.resource.database.tgg_rule.analysis;

public class PKeyColumnReferenceResolver implements org.emftext.language.database.tgg_rule.resource.database.tgg_rule.IDatabase_tgg_ruleReferenceResolver<org.emftext.language.database.PKey, org.emftext.language.database.Column> {
	
	private org.emftext.language.database.resource.database.analysis.PKeyColumnReferenceResolver delegate = new org.emftext.language.database.resource.database.analysis.PKeyColumnReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.database.PKey container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.database.tgg_rule.resource.database.tgg_rule.IDatabase_tgg_ruleReferenceResolveResult<org.emftext.language.database.Column> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.database.resource.database.IDatabaseReferenceResolveResult<org.emftext.language.database.Column>() {
			
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
			
			public java.util.Collection<org.emftext.language.database.resource.database.IDatabaseReferenceMapping<org.emftext.language.database.Column>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.database.Column target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.database.Column target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.database.Column element, org.emftext.language.database.PKey container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}