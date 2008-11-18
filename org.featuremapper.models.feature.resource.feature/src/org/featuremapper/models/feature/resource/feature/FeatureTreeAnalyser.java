package org.featuremapper.models.feature.resource.feature; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.*;

import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.resource.feature.analysis.*;

public class FeatureTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected ConstraintConstrainedFeaturesProxyResolver constraintConstrainedFeaturesProxyResolver = new ConstraintConstrainedFeaturesProxyResolver();

	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErrors) {
		if (container instanceof Constraint && reference.getFeatureID() == 2) {
			return constraintConstrainedFeaturesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		return null;
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof Constraint && reference.getFeatureID() == 2) {
			return constraintConstrainedFeaturesProxyResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		constraintConstrainedFeaturesProxyResolver.setOptions(options);
	}
}
