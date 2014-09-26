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
//this is 

//this is 
package kr.re.ec.grigit.jgraphx.test.ui;

//this is a class tweaked by Juho Kang..
//was Glog

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import kr.re.ec.grigit.jgraphx.test.GitController;
import kr.re.ec.grigit.jgraphx.test.GrigitGraphComponent;
import kr.re.ec.grigit.jgraphx.test.GrigitmxGraph;
import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;
import kr.re.ec.grigit.ui.controller.MainController;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revplot.PlotCommit;
import org.eclipse.jgit.revplot.PlotWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.slf4j.LoggerFactory;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.util.mxConstants;

/**
 * A class that extends RevWalker.<br>
 * This is the Class which holds the graph of this program
 * 
 * @author Kang Juho
 * @version 1.0.0
 * 
 */

public class GrigitGraph extends RevWalker {
	// final JFrame frame;
	final protected JPanel panel;
	protected GriGitGraphPane graphPane;
	protected GrigitGraphComponent graphComponent;
	protected GrigitmxGraph graph;

	public GriGitGraphPane getGraphPane() {
		return graphPane;
	}

	public GrigitmxGraph getGraph() {
		return graph;
	}

	public JPanel getPanel() {
		return panel;
	}

	// for singleton
	private GrigitGraph() {
		panel = MainController.getInstance().getJpPaintGit();
		logger = LoggerFactory.getLogger(GrigitGraph.class);

		graphPane = new GriGitGraphPane();
		graph = new GrigitmxGraph();
		graphComponent = new GrigitGraphComponent(graph);
	}

	// for singleton
	/**
	 * Method getInstance.
	 * 
	 * @return CurrentRepository
	 */
	public static GrigitGraph getInstance() {
		return SingletonHolder.instance;
	}

	// for singleton
	private static class SingletonHolder {
		private static final GrigitGraph instance = new GrigitGraph();
	}

	@Override
	public void init() throws Exception {

		// frame = new JFrame();

		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// frame.setVisible(true);

		super.init();
		for (int i = 0; i < graphPane.getCommitList().size(); i++) {
			// logger.info(""
			// + graphPane.getCommitList().get(i).getLane().getPosition());
			// logger.info(""+graphPane.getCommitList().get(i).getRef(0));
		}

		// final mxGraph graph = new mxGraph();
		// final FoldableGraph graph = new FoldableGraph();

		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		graph.setCellsMovable(false);
		graph.setCellsResizable(false);
		graph.setCellsCloneable(false);
		graph.setDropEnabled(false);
		graph.setDisconnectOnMove(false);
		graph.setCellsSelectable(true);
		graph.setCellsEditable(false);
		graph.setEdgeLabelsMovable(false);
		graph.setAllowDanglingEdges(false);

		try {
			ArrayList<NodeCommit> nodeList = new ArrayList<NodeCommit>();
			for (PlotCommit<SwingLane> commit : graphPane.getCommitList()) {
				NodeCommit commitNode = new NodeCommit();
				commitNode.setCommit(commit);
				nodeList.add(commitNode);
				// logger.info("added  :" + commitNode.toString());
			}

			for (int i = 0; i < nodeList.size(); i++) {
				NodeCommit node = nodeList.get(i);
				node.setVertex(true);
				node.setVisible(true);
				node.setGeometry(new mxGeometry(100 + node.getCommit()
						.getLane().getPosition() * 50, 0 + i * 50, 25, 25));
				node.setValue(node.getCommit().getShortMessage());
				node.setStyle(getNodeStyle(node));
				mxCell contentCell = new mxCell();
				contentCell.setVertex(true);
				contentCell.setVisible(true);
				graph.addCell(node);

				if (node.getCommit().getRefCount() != 0) {
					for (int k = 0; k < node.getCommit().getRefCount(); k++) {
						Ref ref = node.getCommit().getRef(k);
						NodeRef rnode = new NodeRef();
						rnode.setRef(ref);

						rnode.setVertex(true);
						rnode.setVisible(true);
						rnode.setGeometry(new mxGeometry(100
								+ node.getCommit().getLane().getPosition() * 50
								+ 40 + 150 * k, 0 + i * 50 + 10, 100, 15));
						rnode.setValue(rnode.getRef().getName());
						graph.addCell(rnode);
					}
				}

				int parentCount = node.getCommit().getParentCount();
				if (parentCount > 0) {
					for (int j = 0; j < parentCount; j++) {
						// logger.info("get Parent node : "
						// + node.getChildNode(nodeList, node.getCommit()
						// .getParent(j)));
						graph.insertEdge(
								parent,
								null,
								" ",
								node,
								node.getChildNode(nodeList, node.getCommit()
										.getParent(j)),
								// mxConstants.STYLE_EDGE+"="+mxConstants.EDGESTYLE_TOPTOBOTTOM+";"+
								mxConstants.STYLE_SHAPE
										+ "="
										+ mxConstants.SHAPE_CONNECTOR
										+ ";"
										+ mxConstants.STYLE_ENDARROW
										+ "="
										+ mxConstants.ARROW_BLOCK
										+ ";"
										+ mxConstants.STYLE_STROKECOLOR
										+ "="
										+ getEdgeColor(node, nodeList, node
												.getChildNode(nodeList,
														node.getCommit()
																.getParent(j))));
					}

				}

			}
		} finally {
			graph.getModel().endUpdate();
		}

		// graphComponent = new GrigitGraphComponent(
		// graph);

		graphComponent.setEnabled(true);
		graphComponent.setOpaque(true);
		graphComponent.getViewport().setBackground(Color.WHITE);
		graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				Object cell = graphComponent.getCellAt(e.getX(), e.getY());

				if (cell != null) {
					System.out.println("cell=" + graph.getLabel(cell));
				}
			}
		});

		// define layout
		// mxGraphLayout layout = new mxHierarchicalLayout(graph);

		// layout using morphing

		// layout using morphing
		/*
		 * graph.getModel().beginUpdate(); try {
		 * layout.execute(graph.getDefaultParent()); } finally { mxMorphing
		 * morph = new mxMorphing(graphComponent, 20, 1.2, 20);
		 * 
		 * morph.addListener(mxEvent.DONE, new mxIEventListener() {
		 * 
		 * public void invoke(Object arg0, mxEventObject arg1) {
		 * graph.getModel().endUpdate(); // fitViewport(); }
		 * 
		 * });
		 * 
		 * morph.startAnimation(); }
		 */
		// frame.setSize(400, 320);
		// frame.getContentPane().add(graphComponent);
		panel.setLayout(new BorderLayout());
		panel.add(graphComponent, BorderLayout.CENTER);
		Rectangle rec = MainController.getInstance().getBounds();

		MainController.getInstance().pack();
		MainController.getInstance().setBounds(rec);
		panel.setVisible(true);

	}

	public GrigitGraphComponent getGraphComponent() {
		return graphComponent;
	}

	@Override
	protected int walkLoop() throws Exception {
		graphPane.getCommitList().source(walk);
		graphPane.getCommitList().fillTo(Integer.MAX_VALUE);

		//frame.setTitle("[" + repoName() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
		// frame.pack();
		panel.setVisible(true);
		// frame.setVisible(true);
		return graphPane.getCommitList().size();
	}

	@Override
	protected void show(final RevCommit c) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	protected RevWalk createWalk() {
		// if (objects)
		// logger.info(CLIText.get().cannotUseObjectsWithGlog);
		final PlotWalk w = new PlotWalk(db);
		w.sort(RevSort.BOUNDARY, true);
		w.sort(RevSort.COMMIT_TIME_DESC, true);
		return w;
	}

	private String getNodeStyle(NodeCommit node) {
		// logger.info("color rgb = " +
		// node.getCommit().getLane().color.getRGB());
		return mxConstants.STYLE_SHAPE
				+ "="
				+ mxConstants.SHAPE_ELLIPSE
				+ ";"
				+ mxConstants.STYLE_FILLCOLOR
				+ "="
				+ String.format("#%02x%02x%02x",
						node.getCommit().getLane().color.getRed(), node
								.getCommit().getLane().color.getGreen(), node
								.getCommit().getLane().color.getBlue());

	}

	private String getEdgeColor(NodeCommit node,
			ArrayList<NodeCommit> nodeList, NodeCommit parent) {
		String result = null;
		int parentCount = node.getCommit().getParentCount();
		if (parentCount > 1) {
			if (node.getCommit().getLane().getPosition() == parent.getCommit()
					.getLane().getPosition()) {

				result = String.format("#%02x%02x%02x", node.getCommit()
						.getLane().color.getRed(),
						node.getCommit().getLane().color.getGreen(), node
								.getCommit().getLane().color.getBlue());
			} else {
				result = String.format("#%02x%02x%02x", parent.getCommit()
						.getLane().color.getRed(),
						parent.getCommit().getLane().color.getGreen(), parent
								.getCommit().getLane().color.getBlue());

			}

		} else if (parentCount == 1) {

			result = String.format("#%02x%02x%02x",
					node.getCommit().getLane().color.getRed(), node.getCommit()
							.getLane().color.getGreen(), node.getCommit()
							.getLane().color.getBlue());

		}
		return result;
	}

	public void repaintAll() {

		
		GitController.getInstance().getCommitList().clear();
		GitController.getInstance().getRefList().clear();
		panel.removeAll();
		logger.info("remove panel");
		graphPane = new GriGitGraphPane();
		graph = new GrigitmxGraph();
		graphComponent = new GrigitGraphComponent(graph);
		logger.info("new init");
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.repaint();
		logger.info("repaint done");

	}

}
