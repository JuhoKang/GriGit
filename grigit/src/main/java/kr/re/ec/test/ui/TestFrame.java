package kr.re.ec.test.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.re.ec.grigit.constants.Constants;

public class TestFrame extends JFrame{
	
	protected JPanel jp;
	protected JScrollPane jsp;
	protected JTextArea talogarea;
	protected JButton jbgitinit;
	protected JButton jbgitopen;
	protected JButton jbgitstatus;
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
		talogarea.append(Constants.TextComponents.LINE_BREAK
							+"wow");
		talogarea.append("\nwow");
		talogarea.append("\nwow");
		talogarea.append("wow");
		talogarea.append("wow");
		talogarea.append("wow");
		talogarea.append("wow");
				
		jsp = new JScrollPane(talogarea);
		
		jbgitinit = new JButton("Git Init");
		jbgitopen = new JButton("Git Open");
		jbgitstatus = new JButton("Git Status");
		
		jp = new JPanel();
				
		
		jtf = new JTextField(10);
		
		jp.add(jtf);
		jp.add(jsp);
		jp.add(jbgitinit);
		jp.add(jbgitopen);
		jp.add(jbgitstatus);
		
		this.add(jp);
		this.setVisible(true);
	}

}
