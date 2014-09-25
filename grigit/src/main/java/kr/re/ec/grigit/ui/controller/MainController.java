package kr.re.ec.grigit.ui.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.jgraphx.test.GitController;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.ui.MainFrame;
import kr.re.ec.grigit.util.PgmMain;
import kr.re.ec.grigit.util.PrintToArea;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.eclipse.jgit.pgm.Die;
import org.eclipse.jgit.pgm.Main;
import org.eclipse.jgit.pgm.TextBuiltin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class MainController extends MainFrame implements ActionListener {

	Logger logger;
	TextBuiltin tb;

	// for singleton
	private MainController() {
		logger = LoggerFactory.getLogger(MainController.class);
	}

	// for singleton
	/**
	 * Method getInstance.
	 * 
	 * @return CurrentRepository
	 */
	public static MainController getInstance() {
		return SingletonHolder.instance;
	}

	// for singleton
	private static class SingletonHolder {
		private static final MainController instance = new MainController();
	}

	public void init() {
		super.init();

		btnCheckout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				GitController.getInstance().checkOut();
				logger.info("checkout");
			}
		});

		btnOpen.addActionListener(this);
		// when you hit ENTER at jtfCommandLine
		jtfCommandLine.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				logger.info("Enter Pressed");

				if (CurrentRepository.getInstance().getRepository() == null) {
					/*
					 * MainController.getInstance().getTaLog() .append("\n" +
					 * "No Repository opened");
					 */
					Style stErr = MainController.getInstance().getDoc()
							.addStyle("Error", null);
					StyleConstants.setBold(stErr, true);
					StyleConstants.setForeground(stErr, Color.red);

					try {
						MainController
								.getInstance()
								.getDoc()
								.insertString(
										MainController.getInstance().getDoc()
												.getLength(),
										"\n No Repository opened", stErr);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jtfCommandLine.setText("");

				} else {

					String commandhead = "--git-dir^"
							+ CurrentRepository.getInstance().getRepository()
									.getDirectory().getAbsolutePath() + "^";
					/*
					 * MainController .getInstance() .getTaLog() .append("\n" +
					 * "Command at " + CurrentRepository.getInstance()
					 * .getRepository().getDirectory() .getAbsolutePath() + "\n"
					 * + "Command is " + jtfCommandLine.getText());
					 */
					String currentCommand;
					currentCommand = "\n"
							+ "Command at "
							+ CurrentRepository.getInstance().getRepository()
									.getDirectory().getAbsolutePath() + "\n"
							+ "Command is " + jtfCommandLine.getText();
					try {
						MainController
								.getInstance()
								.getDoc()
								.insertString(
										MainController.getInstance().getDoc()
												.getLength(), currentCommand,
										null);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					ArrayList<String> commandlist = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(commandhead, "^");
					while (st.hasMoreTokens()) {
						commandlist.add(st.nextToken());
					}
					st = new StringTokenizer(jtfCommandLine.getText(), " ");
					while (st.hasMoreTokens()) {
						commandlist.add(st.nextToken());
					}
					String commandheadarr[] = commandlist
							.toArray(new String[0]);
					PgmMain.main(commandheadarr);

					jtfCommandLine.setText("");
				}
				MainController
						.getInstance()
						.getTpLog()
						.setCaretPosition(
								MainController.getInstance().getDoc()
										.getLength());
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			new OpenRepoSwing(this);
		}

	}
	
	public File chooseFile() {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(this, "Select");
		File file = fc.getSelectedFile();
		if (!isDotGitDir(file)) {
			file = formToGitDir(file);
		}
		logger.info("Opening: " + file.getName());
		return file;
	}

	private boolean isDotGitDir(File file) {
		boolean result = false;
		String filepath = file.getAbsolutePath();
		logger.info("haha :"+filepath);
		logger.info("shjt:"+filepath.substring(filepath.length() - 4));
		if ((filepath.substring(filepath.length() - 4).equals(".git"))) {
			result = true;
			logger.info("has dot");
		}
		return result;
	}

	private File formToGitDir(File file) {
		File result;
		result = new File(file.getAbsolutePath() + "/.git");
		return result;
	}

}
