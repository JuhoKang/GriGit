package kr.re.ec.grigit.jgraphx.test;

import java.util.ArrayList;

import org.eclipse.jgit.revwalk.RevCommit;

import com.mxgraph.model.mxCell;

public class NodeCommit extends mxCell{
	
	private RevCommit commit;
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

	public RevCommit getCommit() {
		return commit;
	}

	public void setCommit(RevCommit commit) {
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
