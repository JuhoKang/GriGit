package kr.re.ec.grigit.test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.GitInit;
import kr.re.ec.grigit.git.GitShowAllCommits;
import kr.re.ec.grigit.git.GitStatus;
import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.test.ui.TestFrame;

import org.eclipse.jgit.pgm.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class TestController extends TestFrame implements ActionListener{
	
	Logger logger;
	String commandhead;
	
	// for singleton
		private static TestController instance = null;

		// for singleton
		static {
			try {
				instance = new TestController();
			} catch (Exception e) {
				throw new RuntimeException("singleton instance intialize error");
			}
		}

		// for singleton
		private TestController() {

		}

		// for singleton
		/**
		 * Method getInstance.
		 * @return CurrentRepository
		 */
		public static TestController getInstance() {
			return instance;
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
		commandhead = "--git-dir^"+ CurrentRepository.getInstance()
				.getRepository().getDirectory().getAbsolutePath() + "^";
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
			File file = chooseFile();
			new OpenRepository(file);
			
		} else if (e.getSource() == jbgitstatus) {
			
			//logger.info("isBare : "+CurrentRepository.getInstance().getRepository().isBare());
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
			
			try{
				ArrayList<String> commandlist = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(commandhead,"^");
				while(st.hasMoreTokens()){
					commandlist.add(st.nextToken());
				}
				st = new StringTokenizer(jtf.getText(), " ");
				while(st.hasMoreTokens()){
					commandlist.add(st.nextToken());
				}
				String commandheadarr[] = commandlist.toArray(new String[0]);
				Main.main(commandheadarr);
			} catch (Exception E){
				logger.info(E.getMessage());
			}
			
			
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
