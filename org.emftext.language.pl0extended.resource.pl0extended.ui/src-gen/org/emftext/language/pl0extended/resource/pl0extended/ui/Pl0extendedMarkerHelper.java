/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.ui;

/**
 * Helper class to add markers to text files based on EMF's
 * <code>org.eclipse.emf.ecore.resource.Resource.Diagnostic</code>. If a resource
 * contains
 * <code>org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextDiag
 * nostic</code>s it uses the more precise information of this extended diagnostic
 * type.
 */
public class Pl0extendedMarkerHelper {
	
	public static final String MARKER_TYPE = org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedUIPlugin.PLUGIN_ID + ".problem";
	
	/**
	 * Marks a file with markers.
	 * 
	 * @param resource The resource that is the file to mark.
	 * 
	 * @throws org.eclipse.core.runtime.CoreException
	 */
	public static void mark(org.eclipse.emf.ecore.resource.Resource resource) throws org.eclipse.core.runtime.CoreException {
		if (resource == null) {
			return;
		}
		org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));
		// URI might not point at a platform file
		if (file == null) {
			return;
		}
		createMarkersFromDiagnostics(resource, file, resource.getErrors(), org.eclipse.core.resources.IMarker.SEVERITY_ERROR);
		createMarkersFromDiagnostics(resource, file, resource.getWarnings(), org.eclipse.core.resources.IMarker.SEVERITY_WARNING);
	}
	
	private static void createMarkersFromDiagnostics(org.eclipse.emf.ecore.resource.Resource resource, org.eclipse.core.resources.IFile file, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics, int markerSeverity) throws org.eclipse.core.runtime.CoreException {
		
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic : diagnostics) {
			try {
				org.eclipse.core.resources.IMarker marker = file.createMarker(MARKER_TYPE);
				marker.setAttribute(org.eclipse.core.resources.IMarker.SEVERITY, markerSeverity);
				marker.setAttribute(org.eclipse.core.resources.IMarker.MESSAGE, diagnostic.getMessage());
				if (diagnostic instanceof org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextDiagnostic) {
					org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextDiagnostic textDiagnostic = (org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextDiagnostic) diagnostic;
					marker.setAttribute(org.eclipse.core.resources.IMarker.LINE_NUMBER, textDiagnostic.getLine());
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_START, textDiagnostic.getCharStart());
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_END, textDiagnostic.getCharEnd() + 1);
				}
				else {
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_START, 0);
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_END, 1);
				}
			} catch (org.eclipse.core.runtime.CoreException ce) {
				if (ce.getMessage().matches("Marker.*not found.")) {
					// ignore
				} else {
					ce.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Removes all markers from a given resource.
	 * 
	 * @param resource The resource where to delete markers from
	 * 
	 * @throws org.eclipse.core.runtime.CoreException
	 */
	public static void unmark(org.eclipse.emf.ecore.resource.Resource resource) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));
		if (file != null) {
			file.deleteMarkers(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedMarkerHelper.MARKER_TYPE, false, org.eclipse.core.resources.IResource.DEPTH_ZERO);
		}
	}
}
