package kr.re.ec.grigit.jgraphx.test.ui;

import java.util.ArrayList;

import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;

import org.eclipse.jgit.revplot.PlotCommit;
import org.eclipse.jgit.revwalk.RevCommit;

import com.mxgraph.model.mxCell;

public class NodeCommit extends mxCell{
	
	private PlotCommit<SwingLane> commit;
	private int level;
	private String labelString = "";
	private boolean hasContentCell;
	private Object contentCell;
	
	public Object getContentCell() {
		return contentCell;
	}
	public void setContentCell(Object contentCell) {
		this.contentCell = contentCell;
	}
	public boolean isHasContentCell() {
		return hasContentCell;
	}
	public void setHasContentCell(boolean hasContentCell) {
		this.hasContentCell = hasContentCell;
	}
	public String getLabelString() {
		return labelString;
	}
	public void setLabelString(String labelString) {
		this.labelString = labelString;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	private boolean visited = false;
	private boolean selected = false;
	
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
