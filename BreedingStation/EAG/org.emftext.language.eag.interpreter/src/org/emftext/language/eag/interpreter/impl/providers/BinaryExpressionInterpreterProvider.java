/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.eag.interpreter.impl.providers;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.language.eag.BinaryOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;
import org.emftext.language.eag.interpreter.impl.references.IReference;
import org.emftext.language.eag.interpreter.numbers.FloatOperationProvider;
import org.emftext.language.eag.interpreter.numbers.IntegerOperationProvider;

public class BinaryExpressionInterpreterProvider extends AbstractInterpreterProvider {

	public static final BinaryExpressionInterpreterProvider INSTANCE = new BinaryExpressionInterpreterProvider();
	
	public static Collection<IOperationProvider<BinaryOperator>> operationProviders;
	
	static {
		operationProviders = new ArrayList<IOperationProvider<BinaryOperator>>();
		operationProviders.add(new IntegerOperationProvider());
		operationProviders.add(new FloatOperationProvider());
	};

	public IReference interpret(BinaryOperator operator, IReference leftRef, IReference rightRef) {
		Object left = leftRef.getTarget();
		Object right = rightRef.getTarget();
		log("BinaryExpressionInterpreterProvider.interpret(" + left + ", " + right + ")");
		return interpretWithConversion(operationProviders, operator, left, right);
	}
}
