/*
 * 
 */
package org.emftext.language.valueflow.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.part.ValueflowDiagramUpdater;
import org.emftext.language.valueflow.diagram.part.ValueflowNodeDescriptor;
import org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry;

/**
 * @generated
 */
public class AgentAgentStatesCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = ValueflowDiagramUpdater
				.getAgentAgentStatesCompartment_7001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((ValueflowNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = ValueflowVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case GiveStateEditPart.VISUAL_ID:
		case TakeStateEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(ValueflowPackage.eINSTANCE
					.getAgent_States());
		}
		return myFeaturesToSynchronize;
	}

}
