/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EObjectReference extends AbstractObjectReference {

	private EObject object;

	public EObjectReference(EObject object) {
		super(object);
		this.object = object;
	}

	@Override
	public IReference getReference(EStructuralFeature feature) {
		return ReferenceFactory.INSTANCE.createReference(object.eGet(feature));
	}
}
