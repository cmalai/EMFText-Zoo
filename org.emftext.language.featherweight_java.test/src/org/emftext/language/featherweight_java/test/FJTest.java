package org.emftext.language.featherweight_java.test;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.featherweight_java.resource.fj.FjResourceFactory;

public class FJTest extends TestCase {

	public static class ParseTest extends TestCase {
		
		private File inputFile;

		public ParseTest(File inputFile) {
			super("Parse " + inputFile.getName());
			this.inputFile = inputFile;
		}
		
		public void runTest() {
			try {
				URI uri = URI.createFileURI(inputFile.getAbsolutePath());
				ResourceSet rs = new ResourceSetImpl();
				Resource r = rs.createResource(uri);
				r.load(null);
				assertNotNull("Parsing should be successful.", r.getContents());
				EList<Diagnostic> errors = r.getErrors();
				for (Diagnostic diagnostic : errors) {
					System.out.println("ERROR: " + diagnostic.getMessage() + " at " + diagnostic.getLine() + ":" + diagnostic.getColumn());
				}
				assertTrue("There should be no errors", errors.size() == 0);
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}
	}
	
	public static Test suite() {
		registerResourceFactories();
		TestSuite suite = new TestSuite("Parse all files from the input folder");
		File inputFolder = new File("input");
		File[] inputFiles = inputFolder.listFiles();
		for (File inputFile : inputFiles) {
			if (inputFile.getName().endsWith(".fj")) {
				suite.addTest(new ParseTest(inputFile));
			}
		}
		return suite;
	}

	private static void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"fj", new FjResourceFactory());
	}
}