package org.emftext.language.eag.interpreter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.eag.Attribute;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.eag.AttributeKind;
import org.emftext.language.eag.Computation;

public class EAGInterpreter {

	public Object interpret(EObject object, AttributeGrammar grammar, Attribute attribute) {
		log("EAGInterpreter.interpret(" + attribute.getName() + ") " + object);
		// find the computations for the attribute
		EList<Computation> computations = grammar.getComputations();
		List<Computation> computationsForAttribute = new ArrayList<Computation>();
		for (Computation computation : computations) {
			if (computation.getTargetAttribute() == attribute) {
				if (computation.getContext().isInstance(object)) {
					computationsForAttribute.add(computation);
				}
			}
		}
		
		// TODO find most special computation
		if (computationsForAttribute.isEmpty()) {
			// no computation found
			log("EAGInterpreter.interpret() no computation found");
			if (attribute.getKind() == AttributeKind.SYNTHESIZED) {
				// use child for computation
				EList<EObject> children = object.eContents();
				for (EObject child : children) {
					Object childResult = interpret(child, grammar, attribute);
					if (childResult != null) {
						return childResult;
					}
				}
			} else {

			}
			return null;
		} else {
			Computation computation = computationsForAttribute.get(0);
			EClassifier type = attribute.getType();
			EObject intitialValue = null;
			if (type instanceof EClass) {
				// type is complex, create new instance
				intitialValue = type.getEPackage().getEFactoryInstance().create((EClass) type);
			}
			ComputationContext context = new ComputationContext(grammar, object, intitialValue);
			ComputationInterpreter interpreter = new ComputationInterpreter();
			
			interpreter.addObjectToInterprete(computation);
			IReference result = interpreter.interprete(context);
			log("EAGInterpreter.interpret(" + attribute.getName() + ") result = " + result);
			return context.getResult();
		}
	}

	private void log(String string) {
	}
}
