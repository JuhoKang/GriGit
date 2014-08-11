package kr.re.ec.grigit.test.ui;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.re.ec.grigit.constants.Constants;

/**
 */
public abstract class TestFrame extends JFrame{
	
	protected JPanel jp;
	
	protected JScrollPane jsp;
	
	protected JTextArea talogarea;
	
	protected JButton jbgitinit;
	protected JButton jbgitopen;
	protected JButton jbgitstatus;
	protected JButton jbfilechoose;
	protected JButton jbshowallcommits;
	protected JButton jbgo;
	
	
	protected JTextField jtf;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6196893744717201632L;

	public TestFrame(){
		
	}
	
	public void init(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		
		
		talogarea = new JTextArea(10,40);
		talogarea.setEditable(false);
		talogarea.setText("This is a area for text");
				
		jsp = new JScrollPane(talogarea);
		
		jbgitinit = new JButton("Git Init");
		jbgitopen = new JButton("Git Open");
		jbgitstatus = new JButton("Git Status");
		jbfilechoose = new JButton("Choose Button");
		jbshowallcommits = new JButton("Show All Commits");
		jbgo = new JButton("Go");
		
		jp = new JPanel();
				
		
		jtf = new JTextField(10);
		
		jp.add(jtf);
		
		jp.add(jsp);
		
		jp.add(jbgitinit);
		jp.add(jbgitopen);
		jp.add(jbgitstatus);
		jp.add(jbfilechoose);
		jp.add(jbshowallcommits);
		jp.add(jbgo);
		
		this.add(jp);
		this.setVisible(true);
	}

}
