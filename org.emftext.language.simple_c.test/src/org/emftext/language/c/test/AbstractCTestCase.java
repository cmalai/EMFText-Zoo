package org.emftext.language.c.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.runtime.IOptions;
import org.emftext.language.simple_c.impl.CPackageImpl;

public class AbstractCTestCase extends TestCase {
	
	protected EObject loadResource(InputStream inputStream,
			String fileIdentifier, EClass type) throws IOException {
		
		EObject fragment = tryToLoadResource(inputStream, fileIdentifier, type);
		assertNotNull(fragment);
		assertSuccessfulParsing(fragment.eResource());
		return fragment;
	}

	protected EObject tryToLoadResource(InputStream inputStream,
			String fileIdentifier, EClass type) throws IOException {
		CResourceImplTestWrapper resource = new CResourceImplTestWrapper();
		Map<String,EClass> options = new HashMap<String,EClass>();
		if(type!=null)
			options.put(IOptions.RESOURCE_CONTENT_TYPE,type);
		resource.load(inputStream,options);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		//if null, type should be selected appropriately in parser
		if(type==null)
			type = CPackageImpl.init().getCompilationUnit();
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to " + type.getName() + ".",
				content.eClass() == type);
		return content;
	}

	private void assertSuccessfulParsing(Resource resource) {
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage());
		}
	}
}
