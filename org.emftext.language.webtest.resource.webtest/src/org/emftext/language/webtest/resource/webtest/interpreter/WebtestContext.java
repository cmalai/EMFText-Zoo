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

package org.emftext.language.webtest.resource.webtest.interpreter;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebtestContext {

    private WebClient webClient = new WebClient();
    
    private HtmlPage currentPage;

	private IWebtestFailureHandler failureHandler;
    
    public WebtestContext(IWebtestFailureHandler failureHandler) {
    	super();
    	this.failureHandler = failureHandler;
    }

	public WebClient getWebClient() {
		return webClient;
	}

	public HtmlPage getCurrentPage() {
		return currentPage;
	}
    
    public void setCurrentPage(String url) throws Exception {
    	currentPage = webClient.getPage(url);
    }

	public void setCurrentPage(HtmlPage page) {
		this.currentPage = page;
	}

	public IWebtestFailureHandler getFailureHandler() {
		return failureHandler;
	}
}
