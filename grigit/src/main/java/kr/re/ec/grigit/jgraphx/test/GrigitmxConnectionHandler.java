package kr.re.ec.grigit.jgraphx.test;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxConnectionHandler;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxCellState;

/**
 * A class that extends mxConnectionHandler. currently deprecated
 * @author Kang Juho
 * @deprecated
 * @version 1.0.0
 * 
 */

public class GrigitmxConnectionHandler extends mxConnectionHandler {

	public GrigitmxConnectionHandler(mxGraphComponent graphComponent) {
		super(graphComponent);
		// TODO Auto-generated constructor stub
	}

	public void mouseMoved(MouseEvent e) {
	//	System.out.println("x:" + e.getX() + "y:" + e.getY());

		mouseDragged(e);

		if (isHighlighting() && !marker.hasValidState()) {
			// System.out.println("situation 1");
			source = null;
		}

		if (!isHighlighting() && source != null) {
			// System.out.println("situation 2");
			int imgWidth = handleSize;
			int imgHeight = handleSize;

			if (connectIcon != null) {
				// System.out.println("situation 3");
				imgWidth = connectIcon.getIconWidth();
				imgHeight = connectIcon.getIconHeight();
			}

			int x = (int) source.getCenterX() - imgWidth / 2;
			int y = (int) source.getCenterY() - imgHeight / 2;

			if (graphComponent.getGraph().isSwimlane(source.getCell())) {
				// System.out.println("situation 5");
				mxRectangle size = graphComponent.getGraph().getStartSize(
						source.getCell());

				if (size.getWidth() > 0) {
					// System.out.println("situation 6");
					x = (int) (source.getX() + size.getWidth() / 2 - imgWidth / 2);
				} else {
					// System.out.println("situation 7");
					y = (int) (source.getY() + size.getHeight() / 2 - imgHeight / 2);
				}
			}

			setBounds(new Rectangle(x, y, imgWidth, imgHeight));
		} else {
			// System.out.println("situation 8");
			setBounds(null);
		}

		if (source != null && (bounds == null || bounds.contains(e.getPoint()))) {
			System.out.println("situation 9");
			// graphComponent.getGraphControl().setCursor(CONNECT_CURSOR);
		//	mxCell currentCell = (mxCell) graphComponent.getCellAt(e.getX(),
			//		e.getY());

			e.consume();
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (!e.isConsumed() && graphComponent.isEnabled() && isEnabled()) {
			System.out.println("drag1");
			// Activates the handler
			if (!active && first != null) {
				System.out.println("drag2");
				double dx = Math.abs(first.getX() - e.getX());
				double dy = Math.abs(first.getY() - e.getY());
				int tol = graphComponent.getTolerance();

				if (dx > tol || dy > tol) {
					System.out.println("drag3");
					active = true;
				}
			}

			if (e.getButton() == 0 || (isActive() && connectPreview.isActive())) {
				System.out.println("drag4");
				mxCellState state = marker.process(e);

				if (connectPreview.isActive()) {
					System.out.println("drag5");
					connectPreview.update(e, marker.getValidState(), e.getX(),
							e.getY());
					setBounds(null);
					e.consume();
				} else {
					System.out.println("drag6");
					source = state;
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("press2");
		if (!graphComponent.isForceMarqueeEvent(e)
				&& !graphComponent.isPanningEvent(e)
				&& !e.isPopupTrigger()
				&& graphComponent.isEnabled()
				&& isEnabled()
				&& !e.isConsumed()
				&& ((isHighlighting() && marker.hasValidState()) || (!isHighlighting()
						&& bounds != null && bounds.contains(e.getPoint())))) {
			System.out.println("press1");
			start(e, marker.getValidState());
			e.consume();
		}
		
	}

}
