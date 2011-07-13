
package org.emftext.language.javaproperties.resource.properties.analysis;

public class PropertiesKEYTokenResolver implements org.emftext.language.javaproperties.resource.properties.IPropertiesTokenResolver {
	
	private org.emftext.language.javaproperties.resource.properties.analysis.PropertiesDefaultTokenResolver defaultTokenResolver = new org.emftext.language.javaproperties.resource.properties.analysis.PropertiesDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.javaproperties.resource.properties.IPropertiesTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
