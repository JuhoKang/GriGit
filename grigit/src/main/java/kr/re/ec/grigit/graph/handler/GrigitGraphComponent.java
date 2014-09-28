package kr.re.ec.grigit.graph.handler;


////////////////////////////////////////////////////////////////////////////////
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

/**
 * A class that extends mxGraphComponent. extended to change the functions of the graphcomponent
 * @author Kang Juho
 * @version 1.0.0
 * 
 */

public class GrigitGraphComponent extends mxGraphComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3302976345466800723L;
	protected GrigitmxGraphHandler graphHandler;
	//protected GrigitmxSelectionCellsHandler selectionCellsHandler;
	//protected GrigitmxConnectionHandler connectionHandler;
	
	public GrigitGraphComponent(mxGraph graph) {
		super(graph);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void createHandlers(){
		setTransferHandler(createTransferHandler());
	//	panningHandler = createPanningHandler();
	//	selectionCellsHandler = createSelectionCellsHandler();
	//	connectionHandler = createConnectionHandler();
		graphHandler = createGraphHandler();
	}
	
	@Override
	protected GrigitmxGraphHandler createGraphHandler()
	{
		return new GrigitmxGraphHandler(this);
	}
	
	@Override
	protected void installResizeHandler(){
		
	}
	
	/*
	protected GrigitmxSelectionCellsHandler createSelectionCellsHandler(){
		return new GrigitmxSelectionCellsHandler(this);
	}
	*/
	/*
	protected GrigitmxConnectionHandler createConnectionHandler(){
		return new GrigitmxConnectionHandler(this);
	}
	*/
	
	
}
