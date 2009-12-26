/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

public class EfactoryLONGTokenResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolver {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultTokenResolver defaultTokenResolver = new org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}