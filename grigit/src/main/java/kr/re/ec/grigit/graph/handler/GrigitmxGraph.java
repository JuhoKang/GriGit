package kr.re.ec.grigit.graph.handler;

import java.awt.Point;
import java.util.StringTokenizer;

import kr.re.ec.grigit.graph.ui.NodeCommit;
import kr.re.ec.grigit.graph.ui.NodeRef;

import com.mxgraph.view.mxGraph;

/**
 * A class that extends mxGraph. extended to change the functions of the graph
 * @author Kang Juho
 * @version 1.0.0
 * 
 */

public class GrigitmxGraph extends mxGraph {
	
	@Override
	public Object[] moveCells(Object[] cells, double dx, double dy) {
		// TODO Auto-generated method stub
		return super.moveCells(cells, dx, dy);
	}

	@Override
	public Object[] moveCells(Object[] cells, double dx, double dy,
			boolean clone) {
		// TODO Auto-generated method stub
		return super.moveCells(cells, dx, dy, clone);
	}

	@Override
	public Object[] moveCells(Object[] cells, double dx, double dy,
			boolean clone, Object target, Point location) {
		// TODO Auto-generated method stub
		return super.moveCells(cells, dx, dy, clone, target, location);
	}

	// Overrides method to disallow edge label editing
	/*
	public boolean isCellEditable(Object cell) {
		return !getModel().isEdge(cell);
	}*/

	// 
	
	/**
	 * Overrides method to provide a cell label in the display
	 * @author Kang Juho
	 * @version 1.0.0
	 * 
	 */
	@Override
	public String convertValueToString(Object cell) {
		if (cell instanceof NodeCommit) {
			NodeCommit nodeC = (NodeCommit) cell;

			return nodeC.getLabelString();
		}

		if (cell instanceof NodeRef) {
			NodeRef nodeR = (NodeRef) cell;
			
			String tokens[] = nodeR.getRef().getName().split("/");
			String refName = null;
			if (nodeR.getRef().getName().contains("/remotes/")) {
				refName = tokens[tokens.length-2]+"/"+tokens[tokens.length-1];
			} else {
				refName = tokens[tokens.length-1];
			}

			if (nodeR.getRef().getName().contains("/tags/")) {
				refName = "tag:"+refName;
			}
		

			if(nodeR.isSelected()){
				return "★"+refName;
			}else{
				return refName;
			}
			
		}

		/*
		 * if (cell instanceof mxCell) { Object value = ((mxCell)
		 * cell).getValue();
		 * 
		 * if (value instanceof Element) { Element elt = (Element) value;
		 * 
		 * if (elt.getTagName().equalsIgnoreCase("person")) { String firstName =
		 * elt.getAttribute("firstName"); String lastName =
		 * elt.getAttribute("lastName");
		 * 
		 * if (lastName != null && lastName.length() > 0) { return lastName +
		 * ", " + firstName; }
		 * 
		 * return firstName; } else if
		 * (elt.getTagName().equalsIgnoreCase("knows")) { return
		 * elt.getTagName() + " (Since " + elt.getAttribute("since") + ")"; }
		 * 
		 * } }
		 */
		return super.convertValueToString(cell);
	}

	/**
	 * Overrides method to store a cell label in the model
	 * @author Kang Juho
	 * @version 1.0.0
	 * 
	 */
	// Overrides method to store a cell label in the model
	public void cellLabelChanged(Object cell){
	
		Object newValue = null;
		boolean autoSize;
		
		if(cell instanceof NodeRef){
			NodeRef nodeR = (NodeRef)cell;
			if(nodeR.isSelected()){
				newValue =  "★"+nodeR.getRef().getName();
			}else{
				newValue = nodeR.getRef().getName();
				}
		}
		if(cell instanceof NodeRef){
			NodeCommit nodeC = (NodeCommit)cell;
			newValue = nodeC.getLabelString();
		}
		
		super.cellLabelChanged(cell, newValue, false);
	}
	
	@Override
	public void cellLabelChanged(Object cell, Object newValue, boolean autoSize) {
		
		if(cell instanceof NodeRef){
			NodeRef nodeR = (NodeRef)cell;
			if(nodeR.isSelected()){
				newValue =  "★"+nodeR.getRef().getName();
			}else{
				newValue = nodeR.getRef().getName();
				}
		}
		if(cell instanceof NodeCommit){
			NodeCommit nodeC = (NodeCommit)cell;
			newValue = nodeC.getLabelString();
		}
		
		/*
		 * if (cell instanceof mxCell && newValue != null) { Object value =
		 * ((mxCell) cell).getValue();
		 * 
		 * if (value instanceof Node) { String label = newValue.toString();
		 * Element elt = (Element) value;
		 * 
		 * if (elt.getTagName().equalsIgnoreCase("person")) { int pos =
		 * label.indexOf(' ');
		 * 
		 * String firstName = (pos > 0) ? label.substring(0, pos).trim() :
		 * label; String lastName = (pos > 0) ? label.substring( pos + 1,
		 * label.length()).trim() : "";
		 * 
		 * // Clones the value for correct undo/redo elt = (Element)
		 * elt.cloneNode(true);
		 * 
		 * elt.setAttribute("firstName", firstName);
		 * elt.setAttribute("lastName", lastName);
		 * 
		 * newValue = elt; } } }
		 */
		super.cellLabelChanged(cell, newValue, autoSize);
	}

}
