package kr.re.ec.grigit.jgraphx.test;





////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class GrigitGraphComponent extends mxGraphComponent{
	
	protected GrigitmxGraphHandler graphHandler;
	protected GrigitmxSelectionCellsHandler selectionCellsHandler;
	protected GrigitmxConnectionHandler connectionHandler;
	
	public GrigitGraphComponent(mxGraph graph) {
		super(graph);
		
		// TODO Auto-generated constructor stub
	}
	
	protected void createHandlers(){
		setTransferHandler(createTransferHandler());
	//	panningHandler = createPanningHandler();
		selectionCellsHandler = createSelectionCellsHandler();
		connectionHandler = createConnectionHandler();
		graphHandler = createGraphHandler();
	}
	
	protected GrigitmxGraphHandler createGraphHandler()
	{
		return new GrigitmxGraphHandler(this);
	}
	
	protected void installResizeHandler(){
		
	}
	
	protected GrigitmxSelectionCellsHandler createSelectionCellsHandler(){
		return new GrigitmxSelectionCellsHandler(this);
	}
	
	protected GrigitmxConnectionHandler createConnectionHandler(){
		return new GrigitmxConnectionHandler(this);
	}
	
	
	
}
