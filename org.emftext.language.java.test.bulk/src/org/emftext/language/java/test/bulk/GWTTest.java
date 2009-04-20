package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;

import org.eclipse.core.runtime.CoreException;

public class GWTTest extends AbstractZipFileInputTest {

	public static final String TEST_FOLDER = "gwt-1.5.3";
	public static final String START_ENTRY = "";
	public static final int    THREAD_NO   = 8;
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO);
	}
	
}
