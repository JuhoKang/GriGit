package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.ui.MainFrame;
import kr.re.ec.grigit.util.PgmMain;

import org.eclipse.jgit.pgm.Die;
import org.eclipse.jgit.pgm.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class MainController extends MainFrame {

	
	Logger logger;
	
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
		
		jtfCommandLine.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String commandhead = "--git-dir^"
						+ CurrentRepository.getInstance().getRepository()
								.getDirectory().getAbsolutePath() + "^";
				
				logger.info("Enter Pressed");

				
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
				
			}
		});
	}

}
