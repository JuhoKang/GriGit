

package kr.re.ec.grigit.jgraphx.test;

import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.event.MouseEvent;
import java.util.TooManyListenersException;

import javax.swing.TransferHandler;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxGraphHandler;
import com.mxgraph.swing.handler.mxGraphTransferHandler;
import com.mxgraph.swing.handler.mxMovePreview;
import com.mxgraph.swing.util.mxGraphTransferable;
import com.mxgraph.swing.util.mxSwingConstants;

public class GrigitmxGraphHandler extends mxGraphHandler{
	
	public GrigitmxGraphHandler(mxGraphComponent graphComponent) {
		super(graphComponent);
		// TODO Auto-generated constructor stub
	}

	public void dragOver(DropTargetDragEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		
	}
	
	protected void installDragGestureHandler()
	{/*
		DragGestureListener dragGestureListener = new DragGestureListener()
		{
			public void dragGestureRecognized(DragGestureEvent e)
			{
				if (graphComponent.isDragEnabled() && first != null)
				{
					final TransferHandler th = graphComponent
							.getTransferHandler();

					if (th instanceof mxGraphTransferHandler)
					{
						final mxGraphTransferable t = (mxGraphTransferable) ((mxGraphTransferHandler) th)
								.createTransferable(graphComponent);

						if (t != null)
						{
							e.startDrag(null, mxSwingConstants.EMPTY_IMAGE,
									new Point(), t, new DragSourceAdapter()
									{

										
										public void dragDropEnd(
												DragSourceDropEvent dsde)
										{
											((mxGraphTransferHandler) th)
													.exportDone(
															graphComponent,
															t,
															TransferHandler.NONE);
											first = null;
										}
									});
						}
					}
				}
			}
		};

		DragSource dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(graphComponent
				.getGraphControl(),
				(isCloneEnabled()) ? DnDConstants.ACTION_COPY_OR_MOVE
						: DnDConstants.ACTION_MOVE, dragGestureListener);
		*/
	}
	
	protected void installDropTargetHandler()
	{
		/*
		DropTarget dropTarget = graphComponent.getDropTarget();

		try
		{
			if (dropTarget != null)
			{
				dropTarget.addDropTargetListener(this);
				currentDropTarget = dropTarget;
			}
		}
		catch (TooManyListenersException tmle)
		{
			// should not happen... swing drop target is multicast
		}
		*/
	}
	
	protected mxMovePreview createMovePreview()
	{
		return null;
		//return new mxMovePreview(graphComponent);
	}

}
