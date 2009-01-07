package org.eclipse.uml2.uml.resource.statemachine.analysis;

public class StatemachineQUOTED_34_34TokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		result = result.replaceAll(java.util.regex.Pattern.quote("\""),"\\\\\"");
		result += "\"";
		result = "\"" + result;
		return result;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0,lexem.length()-1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("\""),"\"");
		return super.resolve(lexem,feature,container,resource);
	}
}
