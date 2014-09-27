package kr.re.ec.grigit.jgraphx.test;

import java.awt.Cursor;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.event.MouseEvent;

import kr.re.ec.grigit.jgraphx.test.ui.NodeCommit;
import kr.re.ec.grigit.jgraphx.test.ui.NodeRef;
import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;

import org.eclipse.jgit.revplot.PlotCommit;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxGraphHandler;
import com.mxgraph.swing.handler.mxMovePreview;
import com.mxgraph.util.mxRectangle;

/**
 * A class that extends mxGraphHandler. extended to change the functions of the
 * graphhandler<br>
 * serveral overrides blocks events that works on mxGraphHandler
 * 
 * @author Kang Juho
 * @version 1.0.0
 * 
 */

public class GrigitmxGraphHandler extends mxGraphHandler {

	NodeCommit nodeHasTemp;
	Logger logger;

	public GrigitmxGraphHandler(mxGraphComponent graphComponent) {
		super(graphComponent);
		nodeHasTemp = null;
		logger = LoggerFactory.getLogger(GrigitmxGraphHandler.class);
		// TODO Auto-generated constructor stub
	}


	public void dragOver(DropTargetDragEvent e) {
	}
	public void mouseDragged(MouseEvent e) {

	}
	
	private static int countLines(String str){
		   String[] lines = str.split("\r\n|\r|\n");
		   return  lines.length;
		}
	
	private static int maxLengthCount(String str){
		
		int max=0;
		String[] lines = str.split("\r\n|\r|\n");
		
		for(int i=0; i<lines.length; i++)
		{
			
			
			if(max<lines[i].length())
				max=lines[i].length();
		}
		
		return max;
	}
	
	


	protected void installDragGestureHandler() {/*
												 * DragGestureListener
												 * dragGestureListener = new
												 * DragGestureListener() {
												 * public void
												 * dragGestureRecognized
												 * (DragGestureEvent e) { if
												 * (graphComponent
												 * .isDragEnabled() && first !=
												 * null) { final TransferHandler
												 * th = graphComponent
												 * .getTransferHandler();
												 * 
												 * if (th instanceof
												 * mxGraphTransferHandler) {
												 * final mxGraphTransferable t =
												 * (mxGraphTransferable)
												 * ((mxGraphTransferHandler) th)
												 * .
												 * createTransferable(graphComponent
												 * );
												 * 
												 * if (t != null) {
												 * e.startDrag(null,
												 * mxSwingConstants.EMPTY_IMAGE,
												 * new Point(), t, new
												 * DragSourceAdapter() {
												 * 
												 * 
												 * public void dragDropEnd(
												 * DragSourceDropEvent dsde) {
												 * ((mxGraphTransferHandler) th)
												 * .exportDone( graphComponent,
												 * t, TransferHandler.NONE);
												 * first = null; } }); } } } }
												 * };
												 * 
												 * DragSource dragSource = new
												 * DragSource(); dragSource.
												 * createDefaultDragGestureRecognizer
												 * (graphComponent
												 * .getGraphControl(),
												 * (isCloneEnabled()) ?
												 * DnDConstants
												 * .ACTION_COPY_OR_MOVE :
												 * DnDConstants.ACTION_MOVE,
												 * dragGestureListener);
												 */
	}

	protected void installDropTargetHandler() {
		/*
		 * DropTarget dropTarget = graphComponent.getDropTarget();
		 * 
		 * try { if (dropTarget != null) {
		 * dropTarget.addDropTargetListener(this); currentDropTarget =
		 * dropTarget; } } catch (TooManyListenersException tmle) { // should
		 * not happen... swing drop target is multicast }
		 */
	}

	protected mxMovePreview createMovePreview() {
		return null;
		// return new mxMovePreview(graphComponent);
	}
	public void mouseReleased(MouseEvent e) {

		Object cell = graphComponent.getCellAt(e.getX(), e.getY());

		if (cell != null) {
			if (cell instanceof NodeCommit) {
				NodeCommit nodeC = (NodeCommit) cell;

				if (nodeC.isSelected()) {
					nodeC.setSelected(false);
				//	logger.info("list size before remove : "
					//		+ GitController.getInstance().getCommitList()
						//			.size());
					GitController.getInstance().getCommitList().remove(nodeC);
				//	logger.info("list size after remove: "
					//		+ GitController.getInstance().getCommitList()
						//			.size());
					nodeC.setLabelString("");
				} else {
					nodeC.setSelected(true);
				//	logger.info("list size before put : "
					//		+ GitController.getInstance().getCommitList()
						//			.size());
					GitController.getInstance().getCommitList().add(nodeC);
				//	logger.info("list size after put : "
					//		+ GitController.getInstance().getCommitList()
						//			.size());
					nodeC.setLabelString("★");

				}
				graphComponent.getGraph().cellLabelChanged(cell, null, false);

			}
			if (cell instanceof NodeRef) {
				NodeRef nodeR = (NodeRef) cell;
				if (nodeR.isSelected()) {
					GitController.getInstance().getRefList().remove(nodeR);
					nodeR.setSelected(false);
				} else {
					GitController.getInstance().getRefList().add(nodeR);
					nodeR.setSelected(true);

				}
				graphComponent.getGraph().cellLabelChanged(cell, null, false);
			}

		}
		graphComponent.updateComponents();

	}

	public void mouseMoved(MouseEvent e) {
	    Object cell = graphComponent.getCellAt(e.getX(), e.getY());
		// System.out.println("x: "+e.getX()+" y:"+e.getY());
		mxCell tempcell = new mxCell();
		Object added = null;
		if (cell != null) {
			if (cell instanceof NodeCommit) {

				NodeCommit nodeC = (NodeCommit) cell;

				if (!nodeC.isHasContentCell()) {
				//	logger.info("making some");
					
					int countLine, maxLength; 
					String tempValue;
					
					countLine=1;
					
					graphComponent.getGraph().getModel().beginUpdate();
					PlotCommit<SwingLane> commit = nodeC.getCommit();
					
					
					
	
					
					tempValue="<html><div style=\"text-align:center\">"+"Commit name : "+commit.name().substring(0, 13)+"\n<hr></div>";
					
					tempValue+="<div style=\"text-align:left\">";
					
					countLine+=1;
					
					
						
						
					if(commit.getParentCount()>0)
					{
						tempValue+="Parents : " + commit.getParent(0).getName().substring(0, 13) + "\n";
						countLine+=1;
					
						if(commit.getParentCount()>1)
						{
					
							for(int i=1; i<commit.getParentCount(); i++)
							{
								for(int j=1; j<=14; j++)
									tempValue+="&nbsp;";
								tempValue+=commit.getParent(i).getName().substring(0, 13) + "\n";
								countLine+=1;
							}
						}
					
					
					}
					
					
					if(commit.getRefCount()>0)
					{
						tempValue+="Ref : " + commit.getRef(0).getName() + "\n";
						countLine+=1;
						
						
						if(commit.getRefCount()>1)
						{
					
							for(int i=1; i<commit.getRefCount(); i++)
							{
								for(int j=1; j<=9; j++)
									tempValue+="&nbsp;";
								tempValue+=commit.getRef(i).getName() + "\n";
								countLine+=1;
							}
						}
						
					}

					tempValue+=
							"Author's name : " + commit.getAuthorIdent().getName() + "\n"
							+ "Author's Email : " + commit.getAuthorIdent().getEmailAddress() + "\n"
							+ "Date : " + commit.getAuthorIdent().getWhen() + "\n"
							+ "<hr>" + commit.getFullMessage();
						
					countLine+=3;
					
					
					
					countLine+=countLines(commit.getFullMessage());
					
					maxLength=maxLengthCount(tempValue);
					
					
					
	
					
					
					tempValue+="</div></html>";
					
					tempcell.setValue(tempValue);
					
					tempcell.setGeometry(new mxGeometry(nodeC.getGeometry()
							.getX() + 20, nodeC.getGeometry().getY(), maxLength*4>300 ? maxLength*4 : 300, countLine*20));
					
					
					tempcell.setVisible(true);
					tempcell.setVertex(true);
				//	logger.info("made");

					added = graphComponent.getGraph().addCell(tempcell);
				//	logger.info("added is made in : " + added);
					graphComponent.getGraph().getModel().endUpdate();
					nodeC.setHasContentCell(true);
					nodeC.setContentCell(added);
					nodeHasTemp = nodeC;
				}

				graphComponent.updateComponents();
			} else {
				if (nodeHasTemp != null) {
					Object[] removecell = { nodeHasTemp.getContentCell() };
				//	logger.info("added is " + nodeHasTemp.getContentCell());
					graphComponent.getGraph().getModel().beginUpdate();
				//	logger.info("erasing");
					graphComponent.getGraph().resizeCell(
							nodeHasTemp.getContentCell(),
							new mxRectangle(0, 0, 0, 0));
					graphComponent.getGraph().removeCells(removecell);
					graphComponent.getGraph().getModel().endUpdate();
					nodeHasTemp.setHasContentCell(false);
					nodeHasTemp = null;
				}

			}
		}
		if (cell == null) {

			if (nodeHasTemp != null) {
				Object[] removecell = { nodeHasTemp.getContentCell() };
			//	logger.info("added is " + nodeHasTemp.getContentCell());
				graphComponent.getGraph().getModel().beginUpdate();
			//	logger.info("erasing");
				graphComponent.getGraph().resizeCell(
						nodeHasTemp.getContentCell(),
						new mxRectangle(0, 0, 0, 0));
				graphComponent.getGraph().removeCells(removecell);
				graphComponent.getGraph().getModel().endUpdate();
				nodeHasTemp.setHasContentCell(false);
				nodeHasTemp = null;
			}
		}

		if (graphComponent.isEnabled() && isEnabled() && !e.isConsumed()) {
			Cursor cursor = getCursor(e);

			if (cursor != null) {
				graphComponent.getGraphControl().setCursor(cursor);
				e.consume();
			} else {
				graphComponent.getGraphControl().setCursor(DEFAULT_CURSOR);
			}
		}
	}

}
