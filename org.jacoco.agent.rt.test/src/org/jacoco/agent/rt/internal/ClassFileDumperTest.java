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
package org.jacoco.agent.rt.internal;

import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jacoco.agent.rt.internal.ClassFileDumper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Unit tests for {@link ClassFileDumper}.
 */
public class ClassFileDumperTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	private byte[] contents;

	@Before
	public void setup() throws IOException {
		contents = "just some bytes".getBytes("UTF-8");
	}

	@Test
	public void testDumpClassWithPackage() throws IOException {
		final File location = new File(folder.getRoot(), "classes");
		final ClassFileDumper dumper = new ClassFileDumper(location.toString());
		dumper.dump("org/jacoco/examples/Foo$Inner", contents);
		assertContents(location, "org/jacoco/examples/Foo$Inner.class");
	}

	@Test
	public void testDumpClassInDefaultPackage() throws IOException {
		final File location = new File(folder.getRoot(), "classes");
		final ClassFileDumper dumper = new ClassFileDumper(location.toString());
		dumper.dump("Main", contents);
		assertContents(location, "Main.class");
	}

	@Test
	public void testNoDumps() throws IOException {
		final ClassFileDumper dumper = new ClassFileDumper(null);
		dumper.dump("Main", contents);
	}

	private void assertContents(File location, String filename)
			throws IOException {
		InputStream in = new FileInputStream(new File(location, filename));
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int b;
		while ((b = in.read()) != -1) {
			buffer.write(b);
		}
		in.close();
		assertArrayEquals(contents, buffer.toByteArray());
	}

}
