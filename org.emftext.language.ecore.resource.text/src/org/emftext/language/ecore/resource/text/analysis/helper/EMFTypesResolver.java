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
package org.emftext.language.ecore.resource.text.analysis.helper;

import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class EMFTypesResolver {
	
	public void doResolve(java.lang.String identifier, 
			Resource container, 
			org.eclipse.emf.ecore.EReference reference, 
			int position, 
			boolean resolveFuzzy, 
			org.emftext.runtime.resource.IReferenceResolveResult<?> result) {
		
		TreeIterator<EObject> contents = container.getAllContents();
		
		addResults(identifier, contents, resolveFuzzy, result);
		addResults(identifier, EcorePackage.eINSTANCE.getEClassifiers().iterator(), resolveFuzzy, result);
	}

	private void addResults(String identifier, Iterator<?> contents,
			boolean resolveFuzzy, IReferenceResolveResult result) {
		while (contents.hasNext() ) {
			Object next = contents.next();
			if (next instanceof EClassifier) {
				EClassifier classifier = (EClassifier) next;
				
				if (resolveFuzzy) {			
					if (classifier.getName().startsWith(identifier)) {
						result.addMapping(classifier.getName(), classifier);
					}
				} else {
					if (classifier.getName().equals(identifier)) {
						result.addMapping(identifier, classifier);
					}
				}
			}
		}
	}

	
}


	
