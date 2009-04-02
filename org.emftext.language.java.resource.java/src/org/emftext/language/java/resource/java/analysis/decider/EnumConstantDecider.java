package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.ClassifiersPackage;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.references.Reference;

public class EnumConstantDecider implements IResolutionTargetDecider {

	public boolean continueAfterReference() {
		return true;
	}

	public EList<? extends EObject> getAdditionalCandidates(EObject container) {
		return null;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof EnumConstant) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean lookInto(EObject container, EReference containingReference) {
		if (ClassifiersPackage.Literals.ENUMERATION__CONSTANTS.equals(containingReference)) {
			return  true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference;
	}

}
