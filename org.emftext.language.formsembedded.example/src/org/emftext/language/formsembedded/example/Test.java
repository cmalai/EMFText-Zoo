package org.emftext.language.formsembedded.example;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.forms.Form;
import org.emftext.language.forms.Group;
import org.emftext.language.forms.interpreter.FormInterpreter;
import org.emftext.language.forms.resource.forms.mopp.FormsResourceFactory;
import java.util.List;


public class Test {
	public static void main (String [] args) {
	Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap ( ).put ( "forms" , new FormsResourceFactory ( ) ) ;
	URIConverter.URI_MAP.put ( URI.createURI ( "platform:/resource/" ) , URI.createURI ( "../" ) ) ;
	new Test ( ).printAndShowForm ( ) ;
}
	public void printAndShowForm () {
	Form f = ( org.emftext.language.forms.Form ) new org.emftext.language.forms.interpreter.FormInterpreter ( ).load ( "platform:/resource/org.emftext.language.formsembedded.example/src/org/emftext/language/formsembedded/example/Test.formsembedded.forms" ) ;
	new FormInterpreter ( ).interprete ( f ) ;
	List < Group > groups = f.getGroups ( ) ;
	for ( Group next : groups ) {
		System.out.println ( "Group: " + next ) ;
	}
}
}