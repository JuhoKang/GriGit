package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.ui.MenuBarFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
				try {
					GrigitGraph.getInstance().init();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MainController.getInstance().getJpPaintGit().add(GrigitGraph.getInstance().getPanel());
				MainController.getInstance().getJpPaintGit().repaint();
				MainController.getInstance().getJpPaintGit().revalidate();
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
		if(isDotGitDir(file)){
			file = formToGitDir(file);
		}
		logger.info("Opening: " + file.getName());
		return file;
	}
	
	private boolean isDotGitDir(File file){
		boolean result = false;
		String filepath = file.getAbsolutePath();
		if(filepath.substring(filepath.length()-4).equals(".git") == false){
			result = true;
		}
		
		return result;
	}
	private File formToGitDir(File file){
		File result;
		result = new File(file.getAbsolutePath()+"/.git");
		return result;
	}

}
