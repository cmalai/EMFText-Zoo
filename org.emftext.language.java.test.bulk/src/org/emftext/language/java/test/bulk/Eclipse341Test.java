package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.emftext.language.java.test.util.ThreadedTestSuite;

public class Eclipse341Test extends AbstractZipFileInputTest {
	
	public static final String INPUT_FILE = BULK_INPUT_DIR + "eclipse-sourceBuild-srcIncluded-3.4.1.zip";

	public static Test suite() throws CoreException, IOException {
		// run with 8 threads and wait for maximal 5 minutes
		TestSuite suite = new ThreadedTestSuite("Suite testing all files in the eclipse 3.4.1 zip file", 5 * 60 * 1000, 16);
		addToTestSuite(suite, getTestsForZipFileEntries(INPUT_FILE, false));
		return suite;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}

	@Override
	protected String getTestInputFolder() {
		return null;
	}
}
