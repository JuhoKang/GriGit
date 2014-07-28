package kr.re.ec.test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import kr.re.ec.git.GitInit;
import kr.re.ec.test.ui.TestFrame;

public class TestController extends TestFrame implements ActionListener{
	
	public TestController() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		super.init();
		jbgitinit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbgitinit){
			
				new GitInit(jtf.getText());

		}
	}

}
