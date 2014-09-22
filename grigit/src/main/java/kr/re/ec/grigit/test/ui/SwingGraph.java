package kr.re.ec.grigit.test.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingGraph extends JFrame{

	
	public SwingGraph() {
		/*
		// TODO Auto-generated constructor stub
		JLabel jl = new LNodeCommit(this.getGraphics(), null, 40, 40);
		this.add(jl);
		*/
	}
	
	
	public static void main(String[] args) {
		/*
		SwingGraph sg = new SwingGraph();
		sg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sg.setSize(400, 320);
		sg.setVisible(true);
		*/
		SwingLog sl = new SwingLog();
		try {
			sl.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("shit");
	}
	
	
}
