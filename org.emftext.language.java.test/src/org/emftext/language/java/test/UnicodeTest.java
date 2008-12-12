package org.emftext.language.java.test;

import org.junit.Test;

public class UnicodeTest extends AbstractJavaParserTest {

	@Test
	public void testUnicodeInput() {
		try {
			assertParsesToClass("unicode\\Unicode");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}

}
