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
package org.emftext.language.dot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.dot.resource.dot.DotEProblemType;
import org.emftext.language.dot.resource.dot.IDotResourcePostProcessor;
import org.emftext.language.dot.resource.dot.mopp.DotResource;
import org.emftext.language.dot.util.ExeUtil;
import org.emftext.language.dot.util.Pair;

// TODO this should rather be a builder
public class DotPostProcessor implements IDotResourcePostProcessor {

	private static final String dotExecutable = getDOTExecutable();

	public void process(DotResource resource) {
		if (!testDOT()) {
			String path = System.getenv("PATH"); //$NON-NLS-1$
			resource.addError("Cannot run DOT execuatble. Please make sure that it is contained in your PATH variable (" + path +").", DotEProblemType.ANALYSIS_PROBLEM, null); //$NON-NLS-1$
			return;
		}

		final IFile file = WorkspaceSynchronizer.getFile(resource);
		final String message = runDOT(file.getProjectRelativePath().toOSString(),
				file.getProject().getLocation().toOSString());

		if (message != null) {
			resource.addError("DOT finished with \"" + message + "\"", DotEProblemType.ANALYSIS_PROBLEM, null); //$NON-NLS-1$
		} else {
			try {
				file.getProject().refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// Do nothing
			}
		}
	}

	private String runDOT(String file, String workingDir) {
		List<String> arguments = new ArrayList<String>();
		arguments.add(dotExecutable);
		arguments.add("-Tpdf");//$NON-NLS-1$
		arguments.add("-O");//$NON-NLS-1$
		arguments.add(file);

		RunCallback callback = new RunCallback();
		ExeUtil.runExe(arguments, callback, new File(workingDir), true);

		if (callback.getExit() != 0) {
			return callback.getStderr();
		}

		return null;
	}

	private static String getDOTExecutable() {
		String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH); //$NON-NLS-1$
		if (os.startsWith("windows")) { //$NON-NLS-1$
			return "dot.exe"; //$NON-NLS-1$
		}
		return "dot"; //$NON-NLS-1$
	}

	private boolean testDOT() {
		List<String> arguments = new ArrayList<String>();

		arguments.add(dotExecutable);
		arguments.add("-V");//$NON-NLS-1$

		RunCallback callback = new RunCallback();
		ExeUtil.runExe(arguments, callback, true);

		return !callback.isError();
	}

	private class RunCallback implements
			org.emftext.language.dot.util.RunCallback {

		private int exit;
		private boolean error = false;

		private String stderr;

		public void exit(int exitCode) {
			exit = exitCode;
		}

		public void interrupted(InterruptedException ie) {
			error = true;
		}

		public void ioError(IOException ioe) {
			error = true;
		}

		public void result(Pair<String, String> pair) {
			stderr = pair.getRight();
		}

		public int getExit() {
			return exit;
		}

		public boolean isError() {
			return error;
		}

		public String getStderr() {
			return stderr;
		}

	}

	public void terminate() {
		// do nothing
	}
}
