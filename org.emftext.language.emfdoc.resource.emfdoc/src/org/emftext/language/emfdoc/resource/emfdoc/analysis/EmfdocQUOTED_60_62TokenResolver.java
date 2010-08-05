/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.emfdoc.resource.emfdoc.analysis;

public class EmfdocQUOTED_60_62TokenResolver implements org.emftext.language.emfdoc.resource.emfdoc.IEmfdocTokenResolver {
	
	private org.emftext.language.emfdoc.resource.emfdoc.analysis.EmfdocDefaultTokenResolver defaultTokenResolver = new org.emftext.language.emfdoc.resource.emfdoc.analysis.EmfdocDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += ">";
		result = "<" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.emfdoc.resource.emfdoc.IEmfdocTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
