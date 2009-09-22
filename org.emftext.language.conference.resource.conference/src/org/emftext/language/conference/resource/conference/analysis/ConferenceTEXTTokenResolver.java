package org.emftext.language.conference.resource.conference.analysis;

public class ConferenceTEXTTokenResolver implements org.emftext.language.conference.resource.conference.IConferenceTokenResolver {
	
	private org.emftext.language.conference.resource.conference.analysis.ConferenceDefaultTokenResolver defaultTokenResolver = new org.emftext.language.conference.resource.conference.analysis.ConferenceDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.conference.resource.conference.IConferenceTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
