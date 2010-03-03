/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;

import java.math.BigInteger;
import java.util.Map;

import org.emftext.language.java.literals.HexIntegerLiteral;
import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.IJavaTokenResolver;

public class JavaHEX_INTEGER_LITERALTokenResolver implements IJavaTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexIntegerLiteral;
		assert value instanceof BigInteger;
		return HEX_PREFIX + ((BigInteger) value).toString(16);
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IJavaTokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getHexIntegerLiteral());
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		
		lexem = lexem.substring(2);
		
		JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 16, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
