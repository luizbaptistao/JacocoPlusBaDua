/*******************************************************************************
 * Copyright (c) 2009, 2014 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *    
 *******************************************************************************/
package org.jacoco.ant;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.junit.Test;

/**
 * Simple test target for Java applications ant JUnit4 tests. To assert
 * execution it creates an empty file <code>target.txt</code> in the working
 * directory.
 */
public class TestTarget {

	@Test
	public void testNothing() throws IOException {
		System.out.println("Target executed");
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Target executed");

		// Wait for termination file to turn up
		// This option puts the target in a pseudo 'server' mode
		if (args.length == 1) {
			final File termFile = new File(args[0]);

			while (!termFile.exists()) {
				Thread.sleep(100);
			}
		}
	}

	/**
	 * @return location where this class is located
	 */
	public static String getClassPath() {
		final String name = TestTarget.class.getName();
		final String res = "/" + name.replace('.', '/') + ".class";
		String loc = TestTarget.class.getResource(res).getFile();
		try {
			loc = URLDecoder.decode(loc, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return loc.substring(0, loc.length() - res.length());
	}

}
