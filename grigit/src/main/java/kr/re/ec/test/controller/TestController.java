package kr.re.ec.test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.omg.CORBA.Current;

import kr.re.ec.CurrentRepository;
import kr.re.ec.git.GitInit;
import kr.re.ec.git.GitStatus;
import kr.re.ec.git.OpenRepository;
import kr.re.ec.test.ui.TestFrame;

public class TestController extends TestFrame implements ActionListener{
	
	public TestController() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		super.init();
		jbgitinit.addActionListener(this);
		jbgitopen.addActionListener(this);
		jbgitstatus.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbgitinit){
			
			new GitInit(jtf.getText());

		} else if (e.getSource() == jbgitopen) {
			
			new OpenRepository(jtf.getText());
			
		} else if (e.getSource() == jbgitstatus) {
			
			new GitStatus(CurrentRepository.getRepository());
		
		}
	}

}
