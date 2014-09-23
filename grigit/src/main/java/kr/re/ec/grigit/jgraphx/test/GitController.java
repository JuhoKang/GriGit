package kr.re.ec.grigit.jgraphx.test;

import java.util.ArrayList;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.CheckOut;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.jgraphx.test.ui.NodeCommit;
import kr.re.ec.grigit.ui.controller.MainController;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitController {

	ArrayList<NodeCommit> commitList;

	Logger logger;

	// for singleton
	private GitController() {
		logger = LoggerFactory.getLogger(MainController.class);
		commitList = new ArrayList<NodeCommit>();
	}

	// for singleton
	/**
	 * Method getInstance.
	 * 
	 * @return CurrentRepository
	 */
	public static GitController getInstance() {
		return SingletonHolder.instance;
	}

	// for singleton
	private static class SingletonHolder {
		private static final GitController instance = new GitController();
	}

	public ArrayList<NodeCommit> getCommitList() {
		return commitList;
	}

	public void setCommitList(ArrayList<NodeCommit> commitList) {
		this.commitList = commitList;
	}

	public int checkOut() {
		
		if(!commitList.isEmpty()){
			if(commitList.size() == 1){
				new CheckOut(CurrentRepository.getInstance().getRepository(), commitList.get(0).getCommit().getName());
			//	new AlertDialog("Checkout commit : "+commitList.get(0).getCommit().getName());
				WriteToPane.getInstance().write("Checkout commit : "+commitList.get(0).getCommit().getName()+"\n", 
						TextStyles.getInstance().ALERT);
				
				logger.info("repaint all begin");
				GrigitGraph.getInstance().repaintAll();
				logger.info("repaint all end");
				MainController.getInstance().repaint();
			} else {
				WriteToPane.getInstance().write("You should select one commit or a branch\n", 
						TextStyles.getInstance().ALERT);
				//new AlertDialog("You should select one commit or a branch");				
			}
			
		} else {
			WriteToPane.getInstance().write("You should select one commit or a branch\n", 
					TextStyles.getInstance().ALERT);
		}
		

		// for test
		return 1;
	}

	public int checkOut(String name) {
		new CheckOut(CurrentRepository.getInstance().getRepository(), name);

		// for test
		return 1;
	}

	public int branch() {

		// for test
		return 1;
	}

}
