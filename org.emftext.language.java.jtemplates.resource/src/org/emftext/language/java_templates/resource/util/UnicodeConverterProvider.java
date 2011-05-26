/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java_templates.resource.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateInputStreamProcessorProvider;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateOptionProvider;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateOptions;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateInputStreamProcessor;
import org.emftext.language.java.jtemplates.resource.javatemplate.util.JavatemplateUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements IJavatemplateOptionProvider, IJavatemplateInputStreamProcessorProvider {

	public JavatemplateInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new JavatemplateUnicodeConverter(inputStream);
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJavatemplateOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}
