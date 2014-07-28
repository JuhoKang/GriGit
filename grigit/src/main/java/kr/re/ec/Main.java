package kr.re.ec;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.mxgraph.swing.util.mxSwingConstants;
import com.mxgraph.util.mxConstants;

public class Main{
	
	public static void main(String[] args) {

		//================			Use Click Handler
		//ClickHandler frame = new ClickHandler();
		
		
		//================			Use HelloWorld!
		//HelloWorld frame = new HelloWorld();
		
		
		//================			Use CustomCanvas
		//CustomCanvas frame = new CustomCanvas();
		
		
		//================			Use FixedPoints
		//FixedPoints frame = new FixedPoints();
		
		//================			Use Delete Edge
		//DeleteEdge frame = new DeleteEdge();
		//How can I remove certain Vertex?
		
		//================			Use Validation
		//Validation frame = new Validation();
		
		//================			Use UserObject
		//UserObject frame = new UserObject();
		//What is diff with HelloWorld?
		
		//================			Use Port
		Port frame = new Port();
		//  We don't need this Class.
		 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
