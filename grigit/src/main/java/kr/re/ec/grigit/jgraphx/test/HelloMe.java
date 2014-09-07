package kr.re.ec.grigit.jgraphx.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class HelloMe extends JFrame {

	Logger logger;

	public HelloMe() {

		super("Hello Me");

		logger = LoggerFactory.getLogger(HelloMe.class);

		mxGraph graph = new mxGraph();
		graph.setCellsMovable(false);
		Object parent = graph.getDefaultParent();

		try {
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
			}

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
			for (RevCommit commit : commits) {
				NodeCommit commitNode = new NodeCommit();
		//		commitNode.setCommit(commit);
				nodeList.add(commitNode);
				logger.info("added  :" + commitNode.toString());
			}

			Stack<NodeCommit> nodeStack = new Stack<NodeCommit>();
			NodeCommit root = nodeList.get(0);
			root.setGeometry(new mxGeometry(0, 0, 40, 40));
			root.setVertex(true);
			root.setValue(root.getCommit().getShortMessage());
			root.setVisible(true);
			nodeStack.push(root);
			graph.addCell(root);
			logger.info("push :" + root);

			while (!nodeStack.isEmpty()) {

				NodeCommit n = (NodeCommit) nodeStack.peek();
				logger.info("peek :"+n);
				NodeCommit child = getUnvisitedChildNode(nodeList, n);

				if (child != null) {
					child.Visit();
					// print
					//child.setParent(n);
					mxGeometry geo = new mxGeometry();
					geo.setHeight(n.getGeometry().getHeight());
					geo.setWidth(n.getGeometry().getWidth());
					geo.setX(n.getGeometry().getX());
					geo.setY(n.getGeometry().getY()+50);
					child.setGeometry(geo);
					//child.insertEdge(child.getParent(), false);
					child.setValue(child.getCommit().getShortMessage());
					//child.setEdge(true);
					child.setVertex(true);
					child.setVisible(true);
					graph.addCell(child);
					nodeStack.push(child);
					logger.info("push :" + child + "geo: centerx:"
							+ child.getGeometry().getX() + "\tcentery:"
							+ child.getGeometry().getY() + "\twidth:"
							+ child.getGeometry().getWidth() + "\theight:"
							+ child.getGeometry().getHeight());
				} else {
					nodeStack.pop();
					logger.info("pop");
				}
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

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);

	}

	public void main(String[] args) {

		HelloMe frame = null;
		frame = new HelloMe();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);

	}

	private NodeCommit getUnvisitedChildNode(ArrayList<NodeCommit> list,
			NodeCommit node) {
		RevCommit commit = node.getCommit();
		int countParent;
		countParent = commit.getParentCount();
		NodeCommit resultParent = null;

		for (int i = 0; i < countParent; i++) {
			if (node.getChildNode(list, commit.getParent(i)).isVisited() == false) {
				resultParent = node.getChildNode(list, commit.getParent(i));
				break;
			}
		}

		return resultParent;
	}

}
