/*
 * Copyright (C) 2010, Robin Rosenberg <robin.rosenberg@dewire.com>
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

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.jgraphx.test.GraphAlgo;
import kr.re.ec.grigit.jgraphx.test.GrigitGraphComponent;
import kr.re.ec.grigit.jgraphx.test.NodeCommit;
import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.revplot.PlotCommit;
import org.eclipse.jgit.revplot.PlotWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;

public class Glog extends RevWalker{
	final JFrame frame;

	final GriGitGraphPane graphPane;

	public Glog() throws Exception {
		
		//tempo code
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		/*
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				frame.dispose();
			}
		});
		
*/
		
		
		graphPane = new GriGitGraphPane();

		
		
		//final JScrollPane graphScroll = new JScrollPane(graphPane);
/*
		final JPanel buttons = new JPanel(new FlowLayout());
		final JButton repaint = new JButton();
	//	repaint.setText(CLIText.get().repaint);
		repaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphPane.repaint();
			}
		});
		//buttons.add(repaint);*/
		/*
		final JPanel world = new JPanel(new BorderLayout());
		world.add(buttons, BorderLayout.SOUTH);
		world.add(graphScroll, BorderLayout.CENTER);
*/
	//	frame.getContentPane().add(world);
		super.init();
		for(int i = 0; i < graphPane.getCommitList().size(); i++){
			logger.info(""+graphPane.getCommitList().get(i).getLane().getPosition());
			//logger.info(""+graphPane.getCommitList().get(i).getRef(0));
		}
		
		final mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		
		graph.getModel().beginUpdate();
		try {
			/*
			new OpenRepository(new File("C:/Users/Kang Juho/git/BiBim/.git"));
			Git git = new Git(CurrentRepository.getInstance().getRepository());
		
			Iterable<RevCommit> commits = null;
			try {
				commits = git.log().all().call();
			} catch (NoHeadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			// make like log
			/*
			 * int count = 0; for (RevCommit commit : commits) {
			 * 
			 * logger.info("LogCommit: Commit time : " +
			 * commit.getCommitTime()+"\n" + "Commit Author :" +
			 * commit.getAuthorIdent() +"\n" + "Commit Commiter :" +
			 * commit.getCommitterIdent() +"\n" + "Commit hash :" +
			 * commit.getId().getName() +"\n" + "Commit message :" +
			 * commit.getFullMessage() +"\n" + "Parent Count :" +
			 * commit.getParentCount() +"\n" // the first commit doesn't have
			 * parent + "Parent (commit^)" + commit.getParent(1) + "\n" +"\n" );
			 * count++; NodeCommit nc = new NodeCommit(); nc.setCommit(commit);
			 * nc.setVertex(true); nc.setValue(commit.getFullMessage()); //
			 * nc.setParent(arg0); nc.setGeometry(new
			 * mxGeometry(30,count*100,50,30)); graph.addCell(nc); count++; }
			 */
			// ArrayList<RevCommit> arcommitlist = Lists.newArrayList(commits);
			/*
			 * NodeCommit firstNode = new NodeCommit(); if(arcommitlist.size() <
			 * 1){ logger.info("No Commits"); }
			 * firstNode.setCommit(arcommitlist.get(0));
			 * firstNode.setGeometry(new mxGeometry(0,0,40,40));
			 * firstNode.setVisible(true);
			 * firstNode.setValue(firstNode.getCommit()); int count = 0;
			 * NodeCommit secondNode = new NodeCommit(); count
			 * =firstNode.getCommit().getParentCount(); if(count > 1){
			 * secondNode.setCommit(firstNode.getCommit().getParent(0)); }
			 */

			ArrayList<NodeCommit> nodeList = new ArrayList<NodeCommit>();
			for (PlotCommit<SwingLane> commit : graphPane.getCommitList()) {
				NodeCommit commitNode = new NodeCommit();
				commitNode.setCommit(commit);
				nodeList.add(commitNode);
				logger.info("added  :" + commitNode.toString());
			}
			
			for(int i = 0; i < nodeList.size(); i++){
				NodeCommit node = nodeList.get(i);
				node.setVertex(true);
				node.setVisible(true);
				node.setGeometry(new mxGeometry(0+node.getCommit().getLane().getPosition()*100,0+i*100,40,40));
				node.setValue(node.getCommit().getShortMessage());
				graph.addCell(node);
			}

			
			/*
			 * Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
			 * 30); Object v2 = graph.insertVertex(parent, null, "World!", 240,
			 * 150, 80, 30); graph.insertEdge(parent,null,null,v1,v2);
			 * NodeCommit nc = new NodeCommit(); mxCell cell = new
			 * mxCell("shit"); cell.setVertex(true); cell.setGeometry(new
			 * mxGeometry(300,300,300,300));
			 * cell.setValue(nc.getCommit().getFullMessage());
			 * graph.addCell(cell); graph.addCell(nc);
			 */
		} finally {
			graph.getModel().endUpdate();
		}

		GrigitGraphComponent graphComponent = new GrigitGraphComponent(graph);
		graphComponent.setEnabled(true);

		// define layout
		//mxGraphLayout layout = new mxHierarchicalLayout(graph);

		// layout using morphing
		
		 // layout using morphing
		/*
        graph.getModel().beginUpdate();
        try {
            layout.execute(graph.getDefaultParent());
        } finally {
            mxMorphing morph = new mxMorphing(graphComponent, 20, 1.2, 20);

            morph.addListener(mxEvent.DONE, new mxIEventListener() {

                public void invoke(Object arg0, mxEventObject arg1) {
                    graph.getModel().endUpdate();
                    // fitViewport();
                }

            });

            morph.startAnimation();
        }
		*/
		frame.setSize(400, 320);
		frame.getContentPane().add(graphComponent);

		
	
		
	}

	@Override
	protected int walkLoop() throws Exception{
		graphPane.getCommitList().source(walk);
		graphPane.getCommitList().fillTo(Integer.MAX_VALUE);
		

		frame.setTitle("[" + repoName() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
		frame.pack();
		frame.setVisible(true);
		return graphPane.getCommitList().size();
	}
	
	@Override
	protected void show(final RevCommit c) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	protected RevWalk createWalk() {
		//if (objects)
		//	logger.info(CLIText.get().cannotUseObjectsWithGlog);
		final PlotWalk w = new PlotWalk(db);
		w.sort(RevSort.BOUNDARY, true);
		w.sort(RevSort.COMMIT_TIME_DESC,true);
		return w;
	}

	private String repoName() {
		final File gitDir = db.getDirectory();
		if (gitDir == null)
			return db.toString();
		String n = gitDir.getName();
		if (Constants.DOT_GIT.equals(n))
			n = gitDir.getParentFile().getName();
		return n;
	}
}

