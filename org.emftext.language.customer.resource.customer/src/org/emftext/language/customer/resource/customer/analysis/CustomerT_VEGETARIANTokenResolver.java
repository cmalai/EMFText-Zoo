package org.emftext.language.customer.resource.customer.analysis;

import org.emftext.language.customer.IsVegetarian;

public class CustomerT_VEGETARIANTokenResolver implements org.emftext.language.customer.resource.customer.ICustomerTokenResolver {
	
	private static final String VEGETARIAN = "vegetarian";
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		IsVegetarian isVegetarian = (IsVegetarian) container;
		if (isVegetarian.isValue()) {
			return VEGETARIAN;
		} else {
			return "";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.customer.resource.customer.ICustomerTokenResolveResult result) {
		if (VEGETARIAN.equals(lexem)) {
			result.setResolvedToken(Boolean.TRUE);
		} else {
			result.setResolvedToken(Boolean.FALSE);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
	
}
