package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JavaIMPORT_ALL_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, org.emftext.runtime.resource.ITextResource resource) {
		return super.resolve(lexem,feature,container,resource);
	}
}
