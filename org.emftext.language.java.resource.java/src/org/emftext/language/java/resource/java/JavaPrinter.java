package org.emftext.language.java.resource.java;


/**
* This is the printer class used by EMFText.
* Users may implement own behavior by overriding printing methods in the printer base.
* The baseclass contains a pretty printer implementation generated by EMFText which
* is not granted to work in all cases, but should work in most cases.
*/
public class JavaPrinter extends JavaPrinterBase {

	public JavaPrinter(java.io.OutputStream o, org.emftext.runtime.resource.ITextResource resource) {
		super(o, resource);
	}
}
