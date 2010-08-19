package org.emftext.language.eag.interpreter.impl;

import org.eclipse.emf.ecore.EStructuralFeature;

public class PlainObjectReference extends ObjectReference {

	public PlainObjectReference(Object object) {
		super(object);
		assert object != null;
	}

	@Override
	public Object get(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(EStructuralFeature feature, Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ObjectReference getReference(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}
}