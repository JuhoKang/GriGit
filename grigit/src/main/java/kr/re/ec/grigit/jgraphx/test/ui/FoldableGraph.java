package kr.re.ec.grigit.jgraphx.test.ui;

import com.mxgraph.view.mxGraph;

public class FoldableGraph extends mxGraph{

	
	/**
	 * Allows expanding tables
	 */
	public boolean isCellFoldable(Object cell, boolean collapse)
	{
		return model.isVertex(cell);
	}
}
