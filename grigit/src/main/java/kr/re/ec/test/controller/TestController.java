package kr.re.ec.test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.re.ec.CurrentRepository;
import kr.re.ec.git.GitInit;
import kr.re.ec.git.GitStatus;
import kr.re.ec.git.OpenRepository;
import kr.re.ec.test.ui.TestFrame;

public class TestController extends TestFrame implements ActionListener{
	
	Logger logger;
	
	public TestController() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		super.init();
		logger = LoggerFactory.getLogger(TestController.class);
		jbgitinit.addActionListener(this);
		jbgitopen.addActionListener(this);
		jbgitstatus.addActionListener(this);
		jbfilechoose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbgitinit){
			
			new GitInit(jtf.getText());

		} else if (e.getSource() == jbgitopen) {
			
			new OpenRepository(jtf.getText());
			
		} else if (e.getSource() == jbgitstatus) {
			
			logger.info("isBare : "+CurrentRepository.getInstance().getRepository().isBare());
			new GitStatus(CurrentRepository.getInstance().getRepository());
		
		} else if (e.getSource() == jbfilechoose) {
			File file = chooseFile();
			//CurrentRepository.getInstance().setRepository(repository);
			
			if(file != null){
				jtf.setText(file.getAbsolutePath());
			}
			
			
		}
	}
	
	public File chooseFile(){
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(this,"OK");
		File file = fc.getSelectedFile();
		logger.info("Opening: " + file.getName());
		return file;
	}

}
