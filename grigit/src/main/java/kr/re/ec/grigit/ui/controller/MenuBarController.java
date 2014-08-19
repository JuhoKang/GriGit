package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.ui.MenuBarFrame;

@SuppressWarnings("serial")
public class MenuBarController extends MenuBarFrame{
	
	Logger logger;
	
	public MenuBarController() {
		logger = LoggerFactory.getLogger(MenuBarController.class);
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		
		mntmOpenRepo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File repodir = chooseFile();
				new OpenRepository(repodir);
			}
		});
		
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
