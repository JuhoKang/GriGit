package kr.re.ec.grigit.ui.controller;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

public class OpenRepoSwing {
	
	Logger logger;
	
	OpenRepoSwing(Component parent){
		
		logger = LoggerFactory.getLogger(OpenRepoSwing.class);
		
		File repodir = chooseFile(parent);
		if (CurrentRepository.getInstance().getRepository() == null) {
			new OpenRepository(repodir);
			try {
				GrigitGraph.getInstance().init();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			WriteToPane.getInstance().write("Grigit can only open One Repository...\nIf you want to open another Repository please RESTART the program", TextStyles.getInstance().ALERT);
		}
	}
	

	public File chooseFile(Component parent) {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(parent, "Select");
		File file = fc.getSelectedFile();
		if (!isDotGitDir(file)) {
			file = formToGitDir(file);
		}
		//logger.info("Opening: " + file.getAbsolutePath());
		return file;
	}

	private boolean isDotGitDir(File file) {
		boolean result = false;
		String filepath = file.getAbsolutePath();
		//logger.info("haha :"+filepath);
		//logger.info("shjt:"+filepath.substring(filepath.length() - 4));
		if ((filepath.substring(filepath.length() - 4).equals(".git"))) {
			result = true;
		//	logger.info("has dot");
		}
		return result;
	}

	private File formToGitDir(File file) {
		File result;
		//logger.info("wow:"+file.getAbsolutePath());
		result = new File(file.getAbsolutePath() + "/.git");
		//logger.info("result:"+result.getAbsolutePath());
		return result;
	}

}
