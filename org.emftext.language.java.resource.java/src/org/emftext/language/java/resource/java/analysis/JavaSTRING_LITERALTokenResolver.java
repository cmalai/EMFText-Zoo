/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.resource.java.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.IJavaTokenResolver;
import org.emftext.language.java.util.CharacterEscaper;

// TODO @mseifert: add conversion of supplementary unicode characters
// These consist of two characters (high and low surrogate).
// The high surrogate is in the range of \ud800..\udbff.
// The low surrogate is in the range of \udc00..\udfff.
// The supplementary unicode characters can not be converted 
// by the InputStreamConverter, because ANTLR does not support
// them.
public class JavaSTRING_LITERALTokenResolver implements IJavaTokenResolver { 

	private JavaDefaultTokenResolver defaultResolver = new JavaDefaultTokenResolver();

	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = defaultResolver.deResolve(value, feature, container);
		
		//escape escapes
		result = CharacterEscaper.escapeEscapedCharacters(result);
		
		result = '"' + result + '"';
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IJavaTokenResolveResult result) {
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

	public void setOptions(Map<?, ?> options) {
	}
}
