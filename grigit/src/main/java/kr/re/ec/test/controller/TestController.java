package kr.re.ec.test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import kr.re.ec.CurrentRepository;
import kr.re.ec.git.GitInit;
import kr.re.ec.git.GitShowAllCommits;
import kr.re.ec.git.GitStatus;
import kr.re.ec.git.OpenRepository;
import kr.re.ec.test.ui.TestFrame;

import org.eclipse.jgit.pgm.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
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
		jbshowallcommits.addActionListener(this);
		jbgo.addActionListener(this);
	}

	/**
	 * Method actionPerformed.
	 * @param e ActionEvent
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
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
			
		} else if (e.getSource() == jbshowallcommits){
			
			new GitShowAllCommits();
			
		} else if (e.getSource() == jbgo){
			
			new org.eclipse.jgit.pgm.Main();
			Main.main(jtf.getText().split(" "));
		}
	}
	
	/**
	 * Method chooseFile.
	 * @return File
	 */
	public File chooseFile(){
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(this,"OK");
		File file = fc.getSelectedFile();
		logger.info("Opening: " + file.getName());
		return file;
	}

}
