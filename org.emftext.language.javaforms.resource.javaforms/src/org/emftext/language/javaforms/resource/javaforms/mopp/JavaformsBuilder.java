/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.javaforms.resource.javaforms.mopp;

public class JavaformsBuilder implements org.emftext.language.javaforms.resource.javaforms.IJavaformsBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return false;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}
