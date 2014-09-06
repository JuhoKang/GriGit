/*
 * Copyright (C) 2008, Shawn O. Pearce <spearce@spearce.org>
 * and other copyright owners as documented in the project's IP log.
 *
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Distribution License v1.0 which
 * accompanies this distribution, is reproduced below, and is
 * available at http://www.eclipse.org/org/documents/edl-v10.php
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials provided
 *   with the distribution.
 *
 * - Neither the name of the Eclipse Foundation, Inc. nor the
 *   names of its contributors may be used to endorse or promote
 *   products derived from this software without specific prior
 *   written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package kr.re.ec.grigit.jgraphx.test.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;

import org.eclipse.jgit.diff.DiffConfig;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.FollowFilter;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.AndRevFilter;
import org.eclipse.jgit.revwalk.filter.AuthorRevFilter;
import org.eclipse.jgit.revwalk.filter.CommitterRevFilter;
import org.eclipse.jgit.revwalk.filter.MessageRevFilter;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//tweaked by Juho Kang deleted the form with the TextBuiltin because i don't need those
abstract public class RevWalker{
	
	protected RevWalk walk;
	
	protected Repository db;
	
	protected RevWalk argWalk;
	
	protected Logger logger;

	boolean objects = false;

	boolean parents = false;

	boolean count = false;

	boolean all = true;

	char[] outbuffer = new char[Constants.OBJECT_ID_LENGTH * 2];

	private final EnumSet<RevSort> sorting = EnumSet.noneOf(RevSort.class);

	private void enableRevSort(final RevSort type, final boolean on) {
		if (on)
			sorting.add(type);
		else
			sorting.remove(type);
	}

	void enableDateOrder(final boolean on) {
		enableRevSort(RevSort.COMMIT_TIME_DESC, on);
	}

	void enableTopoOrder(final boolean on) {
		enableRevSort(RevSort.TOPO, on);
	}

	void enableReverse(final boolean on) {
		enableRevSort(RevSort.REVERSE, on);
	}

	void enableBoundary(final boolean on) {
		enableRevSort(RevSort.BOUNDARY, on);
	}

	//private String followPath;

	private final List<RevCommit> commits = new ArrayList<RevCommit>();

	//protected TreeFilter pathFilter = TreeFilter.ALL;

	private final List<RevFilter> revLimiter = new ArrayList<RevFilter>();

	void addAuthorRevFilter(final String who) {
		revLimiter.add(AuthorRevFilter.create(who));
	}

	void addCommitterRevFilter(final String who) {
		revLimiter.add(CommitterRevFilter.create(who));
	}

	void addCMessageRevFilter(final String msg) {
		revLimiter.add(MessageRevFilter.create(msg));
	}

	//private int maxCount = -1;
	
	
	public void init() throws Exception {
		
		logger = LoggerFactory.getLogger(RevWalker.class);
		new OpenRepository(new File("C:/Users/Kang Juho/git/BiBim/.git"));
		
		db = CurrentRepository.getInstance().getRepository();	
		
		walk = createWalk();
		for (final RevSort s : sorting)
			walk.sort(s, true);
		/*
		if (pathFilter == TreeFilter.ALL) {
			if (followPath != null)
				walk.setTreeFilter(FollowFilter.create(followPath, db
						.getConfig().get(DiffConfig.KEY)));
		} else if (pathFilter != TreeFilter.ALL) {
			walk.setTreeFilter(AndTreeFilter.create(pathFilter,
					TreeFilter.ANY_DIFF));
		}*/

		if (revLimiter.size() == 1)
			walk.setRevFilter(revLimiter.get(0));
		else if (revLimiter.size() > 1)
			walk.setRevFilter(AndRevFilter.create(revLimiter));

		if (all) {
			Map<String, Ref> refs = db.getRefDatabase()
					.getRefs(RefDatabase.ALL);
			for (Ref a : refs.values()) {
				ObjectId oid = a.getPeeledObjectId();
				if (oid == null)
					oid = a.getObjectId();
				try {
					commits.add(walk.parseCommit(oid));
				} catch (IncorrectObjectTypeException e) {
					// Ignore all refs which are not commits
				}
			}
		}

		if (commits.isEmpty()) {
			final ObjectId head = db.resolve(Constants.HEAD);
			if (head == null)
				//logger.info(MessageFormat.format(CLIText.get().cannotResolve,
					//	Constants.HEAD));
			commits.add(walk.parseCommit(head));
		}
		for (final RevCommit c : commits) {
			final RevCommit real = argWalk == walk ? c : walk.parseCommit(c);
			if (c.has(RevFlag.UNINTERESTING))
				walk.markUninteresting(real);
			else
				walk.markStart(real);
		}

		final long start = System.currentTimeMillis();
		logger.info("i'm here1");
		final int n = walkLoop();
		logger.info("i'm here2");
		if (count) {
			final long end = System.currentTimeMillis();
			logger.info(""+n);
			logger.info(" ");
		//	logger.info(MessageFormat.format(CLIText.get().timeInMilliSeconds,
			//		Long.valueOf(end - start)));
		}
	}

	protected RevWalk createWalk() {
		RevWalk result;
		if (objects)
			result = new ObjectWalk(db);
		else if (argWalk != null)
			result = argWalk;
		else
			result = argWalk = new RevWalk(db);
		result.setRewriteParents(false);
		return result;
	}

	protected int walkLoop() throws Exception {
		int n = 0;
		for (final RevCommit c : walk) {
			//if (++n > maxCount && maxCount >= 0)
			//	break;
			show(c);
		}
		if (walk instanceof ObjectWalk) {
			final ObjectWalk ow = (ObjectWalk) walk;
			for (;;) {
				final RevObject obj = ow.nextObject();
				if (obj == null)
					break;
				show(ow, obj);
			}
		}
		return n;
	}

	/**
	 * "Show" the current RevCommit when called from the main processing loop.
	 * <p>
	 * Implement this methods to define the behavior for subclasses of
	 * RevWalkTextBuiltin.
	 *
	 * @param c
	 *            The current {@link RevCommit}
	 * @throws Exception
	 */
	protected abstract void show(final RevCommit c) throws Exception;

	/**
	 * "Show" the current RevCommit when called from the main processing loop.
	 * <p>
	 * The default implementation does nothing because most subclasses only
	 * process RevCommits.
	 *
	 * @param objectWalk
	 *            the {@link ObjectWalk} used by {@link #walkLoop()}
	 * @param currentObject
	 *            The current {@link RevObject}
	 * @throws Exception
	 */
	protected void show(final ObjectWalk objectWalk,
			final RevObject currentObject) throws Exception {
		// Do nothing by default. Most applications cannot show an object.
	}
}
