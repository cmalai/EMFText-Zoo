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
package org.emftext.language.java.closures.resource.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.closures.resource.closure.IClosureInputStreamProcessorProvider;
import org.emftext.language.java.closures.resource.closure.IClosureOptionProvider;
import org.emftext.language.java.closures.resource.closure.IClosureOptions;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureInputStreamProcessor;
import org.emftext.language.java.closures.resource.closure.util.ClosureUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements
	IClosureOptionProvider, IClosureInputStreamProcessorProvider {

	public ClosureInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new ClosureUnicodeConverter(inputStream);
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IClosureOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}
