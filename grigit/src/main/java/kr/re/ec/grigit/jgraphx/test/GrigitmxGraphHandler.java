

package kr.re.ec.grigit.jgraphx.test;

import java.awt.Cursor;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.event.MouseEvent;

import kr.re.ec.grigit.jgraphx.test.ui.NodeCommit;
import kr.re.ec.grigit.jgraphx.test.ui.NodeRef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxGraphHandler;
import com.mxgraph.swing.handler.mxMovePreview;
import com.mxgraph.util.mxRectangle;

/**
 * A class that extends mxGraphHandler. extended to change the functions of the graphhandler<br>
 * serveral overrides blocks events that works on mxGraphHandler
 * @author Kang Juho
 * @version 1.0.0
 * 
 */

public class GrigitmxGraphHandler extends mxGraphHandler{
	
	NodeCommit nodeHasTemp;
	Logger logger;
	
	public GrigitmxGraphHandler(mxGraphComponent graphComponent) {
		super(graphComponent);
		nodeHasTemp = null;
		logger = LoggerFactory.getLogger(GrigitmxGraphHandler.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dragOver(DropTargetDragEvent e){
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		
	}
	
	@Override
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
	
	@Override
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
	
	@Override
	protected mxMovePreview createMovePreview()
	{
		return null;
		//return new mxMovePreview(graphComponent);
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		/*
		if (graphComponent.isEnabled() && isEnabled() && !e.isConsumed())
		{
			mxGraph graph = graphComponent.getGraph();
			double dx = 0;
			double dy = 0;

			if (first != null && (cellBounds != null || movePreview.isActive()))
			{
				double scale = graph.getView().getScale();
				mxPoint trans = graph.getView().getTranslate();

				// TODO: Simplify math below, this was copy pasted from
				// getPreviewLocation with the rounding removed
				dx = e.getX() - first.x;
				dy = e.getY() - first.y;

				if (cellBounds != null)
				{
					double dxg = ((cellBounds.getX() + dx) / scale)
							- trans.getX();
					double dyg = ((cellBounds.getY() + dy) / scale)
							- trans.getY();

					if (gridEnabledEvent)
					{
						dxg = graph.snap(dxg);
						dyg = graph.snap(dyg);
					}

					double x = ((dxg + trans.getX()) * scale) + (bbox.getX())
							- (cellBounds.getX());
					double y = ((dyg + trans.getY()) * scale) + (bbox.getY())
							- (cellBounds.getY());

					dx = Math.round((x - bbox.getX()) / scale);
					dy = Math.round((y - bbox.getY()) / scale);
				}
			}

			if (first == null
					|| !graphComponent.isSignificant(e.getX() - first.x,
							e.getY() - first.y))
			{
				// Delayed handling of selection
				if (cell != null && !e.isPopupTrigger() && isSelectEnabled()
						&& (first != null || !isMoveEnabled()))
				{
					graphComponent.selectCellForEvent(cell, e);
				}

				// Delayed folding for cell that was initially under the mouse
				if (graphComponent.isFoldingEnabled()
						&& graphComponent.hitFoldingIcon(initialCell, e.getX(),
								e.getY()))
				{
					fold(initialCell);
				}
				else
				{
					// Handles selection if no cell was initially under the mouse
					Object tmp = graphComponent.getCellAt(e.getX(), e.getY(),
							graphComponent.isSwimlaneSelectionEnabled());

					if (cell == null && first == null)
					{
						if (tmp == null)
						{
							if (!graphComponent.isToggleEvent(e))
							{
								graph.clearSelection();
							}
						}
						else if (graph.isSwimlane(tmp)
								&& graphComponent.getCanvas()
										.hitSwimlaneContent(graphComponent,
												graph.getView().getState(tmp),
												e.getX(), e.getY()))
						{
							graphComponent.selectCellForEvent(tmp, e);
						}
					}

					if (graphComponent.isFoldingEnabled()
							&& graphComponent.hitFoldingIcon(tmp, e.getX(),
									e.getY()))
					{
						fold(tmp);
						e.consume();
					}
				}
			}
			else if (movePreview.isActive())
			{
				if (graphComponent.isConstrainedEvent(e))
				{
					if (Math.abs(dx) > Math.abs(dy))
					{
						dy = 0;
					}
					else
					{
						dx = 0;
					}
				}

				mxCellState markedState = marker.getMarkedState();
				Object target = (markedState != null) ? markedState.getCell()
						: null;

				// FIXME: Cell is null if selection was carried out, need other variable
				//trace("cell", cell);
ol
				if (target == null
						&& isRemoveCellsFromParent()
						&& shouldRemoveCellFromParent(graph.getModel()
								.getParent(initialCell), cells, e))
				{
					target = graph.getDefaultParent();
				}

				boolean clone = isCloneEnabled()
						&& graphComponent.isCloneEvent(e);
				Object[] result = movePreview.stop(true, e, dx, dy, clone,
						target);

				if (cells != result)
				{
					graph.setSelectionCells(result);
				}

				e.consume();
			}
			else if (isVisible())
			{
				if (constrainedEvent)
				{
					if (Math.abs(dx) > Math.abs(dy))
					{
						dy = 0;
					}
					else
					{
						dx = 0;
					}
				}

				mxCellState targetState = marker.getValidState();
				Object target = (targetState != null) ? targetState.getCell()
						: null;

				if (graph.isSplitEnabled()
						&& graph.isSplitTarget(target, cells))
				{
					graph.splitEdge(target, cells, dx, dy);
				}
				else
				{
					moveCells(cells, dx, dy, target, e);
				}

				e.consume();
			}
		}

		reset();*/
		
	
			Object cell = graphComponent.getCellAt(e.getX(), e.getY());
			
			if (cell != null)
			{
				if(cell instanceof NodeCommit) {
					NodeCommit nodeC = (NodeCommit)cell;
					
					if(nodeC.isSelected()){
						nodeC.setSelected(false);
						logger.info("list size before remove : "+GitController.getInstance().getCommitList().size());
						GitController.getInstance().getCommitList().remove(nodeC);
						logger.info("list size after remove: "+GitController.getInstance().getCommitList().size());
						nodeC.setLabelString("");
					} else{
						nodeC.setSelected(true);
						logger.info("list size before put : "+GitController.getInstance().getCommitList().size());
						GitController.getInstance().getCommitList().add(nodeC);
						logger.info("list size after put : "+GitController.getInstance().getCommitList().size());
						nodeC.setLabelString("★");
						
					}
					graphComponent.getGraph().cellLabelChanged(cell,null,false);
					
					
				}if(cell instanceof NodeRef){
					NodeRef nodeR = (NodeRef)cell;
					if(nodeR.isSelected()){
						nodeR.setSelected(false);
					} else{
						nodeR.setSelected(true);
						
					}
					graphComponent.getGraph().cellLabelChanged(cell,null,false);
				}
				
			}
			graphComponent.updateComponents();
			
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		Object cell = graphComponent.getCellAt(e.getX(), e.getY());
		//System.out.println("x: "+e.getX()+" y:"+e.getY());
		mxCell tempcell = new mxCell();
		Object added = null;
		if(cell != null){
			if(cell instanceof NodeCommit){
				
				NodeCommit nodeC = (NodeCommit)cell;
				
				if(!nodeC.isHasContentCell()){
					logger.info("making some");
					graphComponent.getGraph().getModel().beginUpdate();
					tempcell.setGeometry(new mxGeometry(nodeC.getGeometry().getX()+20,nodeC.getGeometry().getY(),300,300));
					tempcell.setValue(nodeC.getCommit().getFullMessage());
					tempcell.setVisible(true);
					tempcell.setVertex(true);
					logger.info("made");
					
					added = graphComponent.getGraph().addCell(tempcell);
					logger.info("added is made in : "+ added);
					graphComponent.getGraph().getModel().endUpdate();
					nodeC.setHasContentCell(true);
					nodeC.setContentCell(added);
					nodeHasTemp = nodeC;
				}
				
				graphComponent.updateComponents();
			}else{
				if(nodeHasTemp!=null){
					Object[] removecell = {nodeHasTemp.getContentCell()};
					logger.info("added is "+ nodeHasTemp.getContentCell());
					graphComponent.getGraph().getModel().beginUpdate();
					logger.info("erasing");
					graphComponent.getGraph().resizeCell(nodeHasTemp.getContentCell(), new mxRectangle(0,0,0,0));
					graphComponent.getGraph().removeCells(removecell);
					graphComponent.getGraph().getModel().endUpdate();
					nodeHasTemp.setHasContentCell(false);
					nodeHasTemp = null;
				}
				
			}
		}
		if(cell == null){
			
			if(nodeHasTemp!=null){
				Object[] removecell = {nodeHasTemp.getContentCell()};
				logger.info("added is "+ nodeHasTemp.getContentCell());
				graphComponent.getGraph().getModel().beginUpdate();
				logger.info("erasing");
				graphComponent.getGraph().resizeCell(nodeHasTemp.getContentCell(), new mxRectangle(0,0,0,0));
				graphComponent.getGraph().removeCells(removecell);
				graphComponent.getGraph().getModel().endUpdate();
				nodeHasTemp.setHasContentCell(false);
				nodeHasTemp = null;
			}
		}
		
		if (graphComponent.isEnabled() && isEnabled() && !e.isConsumed())
		{
			Cursor cursor = getCursor(e);

			if (cursor != null)
			{
				graphComponent.getGraphControl().setCursor(cursor);
				e.consume();
			}
			else
			{
				graphComponent.getGraphControl().setCursor(DEFAULT_CURSOR);
			}
		}
	}

}
