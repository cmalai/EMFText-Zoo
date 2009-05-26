package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.resource.java.analysis.helper.CharacterEscaper;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

// TODO @mseifert: add conversion of supplementary unicode characters
// These consist of two characters (high and low surrogate).
// The high surrogate is in the range of \ud800..\udbff.
// The low surrogate is in the range of \udc00..\udfff.
// The supplementary unicode characters can not be converted 
// by the InputStreamConverter, because ANTLR does not support
// them.
public class JavaSTRING_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 

	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		
		//escape escapes
		result = CharacterEscaper.escapeEscapedCharacters(result);
		
		result = '"' + result + '"';
		return result;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		// remove double quotes
		assert lexem.charAt(0) == '"';
		assert lexem.charAt(lexem.length() - 1) == '"';
		lexem = lexem.substring(1, lexem.length() - 1);
		// handle escaped characters: 
		// escape sequences: \b \t \n \f \r \" \' \\
		// octal characters: \0 to \377
		// unicode characters (e.g., \u0000)
		
		//TODO @mseifert: either implement escaping (inverse of unescapeEscapedCharacters) 
		//     for deResolve or leave the below .
		lexem = CharacterEscaper.unescapeEscapedCharacters(lexem);
		
		result.setResolvedToken(lexem);
	}
}
