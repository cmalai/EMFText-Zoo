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
package org.emftext.language.java.reusejava.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.reusejava.resource.reusejava.IReusejavaOptionProvider;
import org.emftext.language.java.reusejava.resource.reusejava.IReusejavaOptions;
import org.emftext.language.java.reusejava.resource.reusejava.IReusejavaResourcePostProcessor;
import org.emftext.language.java.reusejava.resource.reusejava.IReusejavaResourcePostProcessorProvider;
import org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaContextDependentURIFragmentFactory;
import org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaReferenceResolverSwitch;
import org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaResource;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class ReuseJavaPostProcessor implements IReusejavaOptionProvider, IReusejavaResourcePostProcessor, IReusejavaResourcePostProcessorProvider {
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IReusejavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(ReusejavaResource resource) {
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				((ReusejavaResource)resource).registerContextDependentProxy(
						new ReusejavaContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new ReusejavaReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy);
			}
		}.repair(resource);
		
		JavaModelCompletion.complete(resource);
		JavaModelCompletion.complete(resource);
	}

	public IReusejavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}