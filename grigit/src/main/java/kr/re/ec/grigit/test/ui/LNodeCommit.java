package kr.re.ec.grigit.test.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;

import org.eclipse.jgit.revplot.PlotCommit;

public class LNodeCommit extends JLabel{

	private double xCoord;
	private double yCoord;
	private double width = 40;
	private double length = 40;
	
	protected JRadioButton selectButton;
	
	protected PlotCommit<SwingLane> commit;
	
	public LNodeCommit(Graphics g, PlotCommit<SwingLane> commit, double x, double y) {
		this.xCoord = x;
		this.yCoord = y;
		this.commit = commit;
		
		paintComponent(g);
	}
	
	
	public PlotCommit<SwingLane> getCommit() {
		return commit;
	}

	public void setCommit(PlotCommit<SwingLane> commit) {
		this.commit = commit;
	}
	
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   Graphics2D g2d = (Graphics2D)g;
		   // Assume x, y, and diameter are instance variables.
		   Ellipse2D.Double circle = new Ellipse2D.Double(xCoord, yCoord, width, length);
		   g2d.fill(circle);
		}
	
	
}
