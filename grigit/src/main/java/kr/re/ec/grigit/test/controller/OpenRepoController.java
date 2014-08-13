package kr.re.ec.grigit.test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.test.ui.OpenRepoFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenRepoController extends OpenRepoFrame implements ActionListener{
	
	Logger logger;
	
	public OpenRepoController(){
		
		logger = LoggerFactory.getLogger(OpenRepoController.class);
		
	}
	
	public void init(){
		super.init();
		
		
		jbfilechoose.setText("Choose File");
		jlguide.setText("Please select your .git directory inside your repository");
		
		jbfilechoose.addActionListener(this);
		
		super.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jbfilechoose){
			File dir = chooseFile();
			CurrentRepository.getInstance().setRepository(new OpenRepository(dir).getRepository());
			TestController.getInstance().init();
		}
		
	}
	
	/**
	 * Method chooseFile.
	 * @return File
	 */
	public File chooseFile(){
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(this,"Select");
		File file = fc.getSelectedFile();
		logger.info("Opening: " + file.getName());
		return file;
	}

}
