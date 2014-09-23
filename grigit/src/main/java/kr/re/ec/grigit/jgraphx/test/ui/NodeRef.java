package kr.re.ec.grigit.jgraphx.test.ui;

import org.eclipse.jgit.lib.Ref;

import com.mxgraph.model.mxCell;

public class NodeRef extends mxCell{

	protected Ref ref;
	private boolean selected = false;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Ref getRef() {
		return ref;
	}

	public void setRef(Ref ref) {
		this.ref = ref;
	}
	
}
