package kr.re.ec.grigit.jgraphx.test;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxConnectionHandler;
import com.mxgraph.util.mxRectangle;

public class GrigitmxConnectionHandler extends mxConnectionHandler{
	
	public GrigitmxConnectionHandler(mxGraphComponent graphComponent) {
		super(graphComponent);
		// TODO Auto-generated constructor stub
	}

	public void mouseMoved(MouseEvent e)
	{
		System.out.println("x:"+e.getX()+"y:"+e.getY());
		
		mouseDragged(e);

		if (isHighlighting() && !marker.hasValidState())
		{
			//System.out.println("situation 1");
			source = null;
		}

		if (!isHighlighting() && source != null)
		{
			//System.out.println("situation 2");
			int imgWidth = handleSize;
			int imgHeight = handleSize;

			if (connectIcon != null)
			{
				//System.out.println("situation 3");
				imgWidth = connectIcon.getIconWidth();
				imgHeight = connectIcon.getIconHeight();
			}

			int x = (int) source.getCenterX() - imgWidth / 2;
			int y = (int) source.getCenterY() - imgHeight / 2;

			if (graphComponent.getGraph().isSwimlane(source.getCell()))
			{
				//System.out.println("situation 5");
				mxRectangle size = graphComponent.getGraph().getStartSize(
						source.getCell());

				if (size.getWidth() > 0)
				{
					//System.out.println("situation 6");
					x = (int) (source.getX() + size.getWidth() / 2 - imgWidth / 2);
				}
				else
				{
					//System.out.println("situation 7");
					y = (int) (source.getY() + size.getHeight() / 2 - imgHeight / 2);
				}
			}

			setBounds(new Rectangle(x, y, imgWidth, imgHeight));
		}
		else
		{
			//System.out.println("situation 8");
			setBounds(null);
		}

		if (source != null && (bounds == null || bounds.contains(e.getPoint())))
		{
			System.out.println("situation 9");
			//graphComponent.getGraphControl().setCursor(CONNECT_CURSOR);
			mxCell currentCell = (mxCell)graphComponent.getCellAt(e.getX(),e.getY());
			
			e.consume();
		}
	}

}
