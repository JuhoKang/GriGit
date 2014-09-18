package kr.re.ec.grigit.jgraphx.test.ui;

import org.eclipse.jgit.lib.Ref;

import com.mxgraph.model.mxCell;

public class NodeRef extends mxCell{

	protected Ref ref;

	public Ref getRef() {
		return ref;
	}

	public void setRef(Ref ref) {
		this.ref = ref;
	}
	
}
