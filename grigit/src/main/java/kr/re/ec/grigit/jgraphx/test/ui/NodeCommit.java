package kr.re.ec.grigit.jgraphx.test.ui;

import java.util.ArrayList;

import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;

import org.eclipse.jgit.revplot.PlotCommit;
import org.eclipse.jgit.revwalk.RevCommit;

import com.mxgraph.model.mxCell;

public class NodeCommit extends mxCell{
	
	private PlotCommit<SwingLane> commit;
	private int level;
	private boolean visited = false;
	
	public boolean isVisited(){
		return visited;
	}
	public void Visit(){
		visited = true;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public NodeCommit(){
		
	}

	public PlotCommit<SwingLane> getCommit() {
		return commit;
	}

	public void setCommit(PlotCommit<SwingLane> commit) {
		this.commit = commit;
	}
	
	public NodeCommit getChildNode(ArrayList<NodeCommit> list, RevCommit  parentcommit){
		NodeCommit resultnode = null;
		
		for(NodeCommit e : list){
			if(e.getCommit().equals(parentcommit)){
				resultnode = e;
			}
		}
		
		return resultnode;
	}

}
