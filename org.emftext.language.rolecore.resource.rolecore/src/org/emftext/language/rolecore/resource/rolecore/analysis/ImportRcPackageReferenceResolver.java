/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.resource.rolecore.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.rolecore.Import;
import org.emftext.language.rolecore.RCPackage;

public class ImportRcPackageReferenceResolver
		implements
		org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.emftext.language.rolecore.Import, org.emftext.language.rolecore.RCPackage> {

	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.Import, org.emftext.language.rolecore.RCPackage> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.Import, org.emftext.language.rolecore.RCPackage>();

	public void resolve(
			java.lang.String identifier,
			org.emftext.language.rolecore.Import container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.emftext.language.rolecore.RCPackage> result) {
		// delegate.resolve(identifier, container, reference, position,
		// resolveFuzzy, result);
		String locationHint = container.getRcPackageLocationHint();
		RCPackage rcPackage = findRCPackage(identifier, locationHint, container);
		if (rcPackage!=null)
			result.addMapping(identifier, rcPackage);
	}

	private RCPackage findRCPackage(String identifier, String locationHint, Import container) {
		if (identifier==null)
			return null;
		RCPackage rcPackage = (RCPackage) EPackage.Registry.INSTANCE.getEPackage(identifier);
		if (rcPackage!=null) {
			return rcPackage;
		} else if (locationHint==null){
			String resourceURI = container.eResource().getURI().toPlatformString(true);
			return loadRCPackage(resourceURI.substring(0, resourceURI.lastIndexOf("/")+1)+container.getPrefix() + ".rolecore");
		} else {
			return loadRCPackage(locationHint + container.getPrefix() + ".rolecore");
		}
	}

	public RCPackage loadRCPackage(String fileURI) {
		// create resource set and resource
		ResourceSet resourceSet = new ResourceSetImpl();
		
		try {
			return (RCPackage) resourceSet.getResource(URI.createPlatformResourceURI(fileURI, true), true)
					.getContents().get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public java.lang.String deResolve(org.emftext.language.rolecore.RCPackage element,
			org.emftext.language.rolecore.Import container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend on any option
	}

}