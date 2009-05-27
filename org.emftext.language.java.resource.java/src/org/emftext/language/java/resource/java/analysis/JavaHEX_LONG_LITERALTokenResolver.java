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

import java.math.BigInteger;

import org.emftext.language.java.literals.HexLongLiteral;
import org.emftext.language.java.literals.LiteralsPackage;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.LONG_SUFFIX;

public class JavaHEX_LONG_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexLongLiteral;
		assert value instanceof BigInteger;
		return HEX_PREFIX + ((BigInteger) value).toString(16) + LONG_SUFFIX;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getLongLiteral());
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		assert lexem.toLowerCase().endsWith(LONG_SUFFIX);
		
		lexem = lexem.substring(2);
		lexem = lexem.substring(0, lexem.length() - 1);
		
		JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 16, result);
	}
}
