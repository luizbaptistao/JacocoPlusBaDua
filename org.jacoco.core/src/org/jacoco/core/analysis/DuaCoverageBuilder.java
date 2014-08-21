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
package org.jacoco.core.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

///**
// * Builder for hierarchical {@link ICoverageNode} structures from single
// * {@link IClassCoverage} nodes. The nodes are feed into the builder through its
// * {@link ICoverageVisitor} interface. Afterwards the aggregated data can be
// * obtained with {@link #getClasses()}, {@link #getSourceFiles()} or
// * {@link #getBundle(String)} in the following hierarchy:
// * 
// * <pre>
// * {@link IBundleCoverage}
// * +-- {@link IPackageCoverage}*
// *     +-- {@link IClassCoverage}*
// *     +-- {@link ISourceFileCoverage}*
// * </pre>
// */
public class DuaCoverageBuilder implements IDuaCoverageVisitor {

	private final Map<String, IDuaClassCoverage> classes;

	// private final Map<String, ISourceFileCoverage> sourcefiles;

	/**
	 * Create a new builder.
	 * 
	 */
	public DuaCoverageBuilder() {
		this.classes = new HashMap<String, IDuaClassCoverage>();
		// this.sourcefiles = new HashMap<String, ISourceFileCoverage>();
	}

	/**
	 * Returns all class nodes currently contained in this builder.
	 * 
	 * @return all class nodes
	 */
	public Collection<IDuaClassCoverage> getClasses() {
		return Collections.unmodifiableCollection(classes.values());
	}

	//
	// /**
	// * Returns all source file nodes currently contained in this builder.
	// *
	// * @return all source file nodes
	// */
	// public Collection<ISourceFileCoverage> getSourceFiles() {
	// return Collections.unmodifiableCollection(sourcefiles.values());
	// }

	// /**
	// * Creates a bundle from all nodes currently contained in this bundle.
	// *
	// * @param name
	// * Name of the bundle
	// * @return bundle containing all classes and source files
	// */
	// public IBundleCoverage getBundle(final String name) {
	// return new BundleCoverageImpl(name, classes.values(),
	// sourcefiles.values());
	// }

	public void visitCoverage(final IDuaClassCoverage coverage) {
		// Only consider classes that actually contain code:
		// if (coverage.getInstructionCounter().getTotalCount() > 0) {
		// final String name = coverage.getName();
		// final IClassCoverage dup = classes.put(name, coverage);
		// if (dup != null && dup.getId() != coverage.getId()) {
		// throw new IllegalStateException(
		// "Can't add different class with same name: " + name);
		// }
		// final String source = coverage.getSourceFileName();
		// if (source != null) {
		// final SourceFileCoverageImpl sourceFile = getSourceFile(source,
		// coverage.getPackageName());
		// sourceFile.increment(coverage);
		// }
		// }
	}

	// private SourceFileCoverageImpl getSourceFile(final String filename,
	// final String packagename) {
	// final String key = packagename + '/' + filename;
	// SourceFileCoverageImpl sourcefile = (SourceFileCoverageImpl) sourcefiles
	// .get(key);
	// if (sourcefile == null) {
	// sourcefile = new SourceFileCoverageImpl(filename, packagename);
	// sourcefiles.put(key, sourcefile);
	// }
	// return sourcefile;
	// }

}