package kr.re.ec.grigit.test.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class OpenRepoFrame extends JFrame{
	
	protected JPanel jpmain;
	protected JButton jbfilechoose;
	protected JLabel jlguide;
		
	public OpenRepoFrame(){
		
	}
	
	public void init(){
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		
		//JPanel
		jpmain = new JPanel();
				
		//JButton
		jbfilechoose = new JButton();
				
		
		
		
		//JLabel
		jlguide = new JLabel(); 
		
		
		
		
		jpmain.add(jbfilechoose);
		jpmain.add(jlguide);
		
		this.add(jpmain);
		
	}

}
