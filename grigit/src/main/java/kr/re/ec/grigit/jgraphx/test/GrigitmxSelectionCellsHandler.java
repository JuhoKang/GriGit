package kr.re.ec.grigit.jgraphx.test;

import java.awt.event.MouseEvent;
import java.util.Iterator;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxCellHandler;
import com.mxgraph.swing.handler.mxSelectionCellsHandler;


/**
 * A class that extends mxSelectionCellsHandler. currently deprecated
 * @author Kang Juho
 * @version 1.0.0
 * @deprecated
 * 
 */

public class GrigitmxSelectionCellsHandler extends mxSelectionCellsHandler{

	public GrigitmxSelectionCellsHandler(mxGraphComponent graphComponent) {
		super(graphComponent);
		// TODO Auto-generated constructor stub
	}
	
	public void mousePressed(MouseEvent e)
	{
		/*
		System.out.println("selectection press 1");
		if (graphComponent.isEnabled()
				&& !graphComponent.isForceMarqueeEvent(e) && isEnabled())
		{
			System.out.println("selectection press 2");
			Iterator<mxCellHandler> it = handlers.values().iterator();

			while (it.hasNext() && !e.isConsumed())
			{
				System.out.println("selectection press 3");
				it.next().mousePressed(e);
			}
		}*/
	}
}
