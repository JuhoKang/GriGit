package kr.re.ec.grigit.jgraphx.test;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class HelloMe extends JFrame{
	
	public HelloMe(){
		
		super("Hello Me");
		
		mxGraph graph = new mxGraph();
		graph.setCellsMovable(false);
		Object parent = graph.getDefaultParent();
		
		try{
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30);
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
			graph.insertEdge(parent,null,null,v1,v2);
			
		} finally{
			graph.getModel().endUpdate();
		}
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
		
		
	}
	public static void main(String[] args) {
		
		HelloMe frame = new HelloMe();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
		
	}

}
