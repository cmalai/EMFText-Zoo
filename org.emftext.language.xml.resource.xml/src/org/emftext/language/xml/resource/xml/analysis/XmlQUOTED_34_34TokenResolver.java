package org.emftext.language.xml.resource.xml.analysis;

import org.emftext.language.xml.resource.xml.IXmlTokenResolveResult;
import org.emftext.language.xml.resource.xml.IXmlTokenResolver;

public class XmlQUOTED_34_34TokenResolver implements IXmlTokenResolver {
	
	private XmlDefaultTokenResolver defaultTokenResolver = new XmlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IXmlTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
