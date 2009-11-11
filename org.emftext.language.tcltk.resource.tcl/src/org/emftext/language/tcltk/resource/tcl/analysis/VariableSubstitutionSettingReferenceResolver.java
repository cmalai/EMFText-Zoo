package org.emftext.language.tcltk.resource.tcl.analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.tcltk.tcl.Set;
import org.emftext.language.tcltk.tcl.Word;

public class VariableSubstitutionSettingReferenceResolver implements org.emftext.language.tcltk.resource.tcl.ITclReferenceResolver<org.emftext.language.tcltk.tcl.VariableSubstitution, org.emftext.language.tcltk.tcl.Set> {
	
	private org.emftext.language.tcltk.resource.tcl.analysis.TclDefaultResolverDelegate<org.emftext.language.tcltk.tcl.VariableSubstitution, org.emftext.language.tcltk.tcl.Set> delegate = new org.emftext.language.tcltk.resource.tcl.analysis.TclDefaultResolverDelegate<org.emftext.language.tcltk.tcl.VariableSubstitution, org.emftext.language.tcltk.tcl.Set>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.tcltk.tcl.VariableSubstitution container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.tcltk.resource.tcl.ITclReferenceResolveResult<org.emftext.language.tcltk.tcl.Set> result) {
		for(Iterator<EObject> i = container.eResource().getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof Set) {
				if (((Set)next).getVariable() instanceof Word) {
					Word w = (Word) ((Set)next).getVariable();
					if (identifier.equals(w.getValue())) {
						result.addMapping(identifier, (Set)next);
						return;
					}
				}
			}
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.tcltk.tcl.Set element, org.emftext.language.tcltk.tcl.VariableSubstitution container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}