package kr.re.ec.grigit.jgraphx.test;

import java.util.ArrayList;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.Checkout;
import kr.re.ec.grigit.git.Merge;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.jgraphx.test.ui.NodeCommit;
import kr.re.ec.grigit.jgraphx.test.ui.NodeRef;
import kr.re.ec.grigit.ui.CheckoutCheckDialogFrame;
import kr.re.ec.grigit.ui.MergeDialogFrame;
import kr.re.ec.grigit.ui.controller.CheckoutCheckDialogController;
import kr.re.ec.grigit.ui.controller.MainController;
import kr.re.ec.grigit.ui.controller.MergeDialog;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitController {

	ArrayList<NodeCommit> commitList;
	ArrayList<NodeRef> refList;

	Logger logger;

	// for singleton
	private GitController() {
		logger = LoggerFactory.getLogger(MainController.class);
		commitList = new ArrayList<NodeCommit>();
		refList = new ArrayList<NodeRef>();
	}

	public ArrayList<NodeRef> getRefList() {
		return refList;
	}

	public void setRefList(ArrayList<NodeRef> refList) {
		this.refList = refList;
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

		if (!(commitList.isEmpty() && refList.isEmpty())) {
			if ((commitList.size() == 1) && (refList.isEmpty())) {

				CheckoutCheckDialogController ccdc = new CheckoutCheckDialogController(
						commitList.get(0).getCommit().getName());
				boolean isOk = ccdc.isOk();
				if (isOk) {
					
					new Checkout(CurrentRepository.getInstance()
							.getRepository(), commitList.get(0).getCommit()
							.getName());
					// new
					// AlertDialog("Checkout commit : "+commitList.get(0).getCommit().getName());
					WriteToPane.getInstance().write(
							"Checkout commit : "
									+ commitList.get(0).getCommit().getName()
									+ "\n", TextStyles.getInstance().ALERT);

					logger.info("repaint all begin");
					GrigitGraph.getInstance().repaintAll();
					logger.info("repaint all end");
					MainController.getInstance().repaint();
				} else {
					System.out.println("here");
				}

			} else if ((refList.size() == 1) && (commitList.isEmpty())) {

				CheckoutCheckDialogController ccdc = new CheckoutCheckDialogController(
						refList.get(0).getRef().getName());
				
				boolean isOk = ccdc.isOk();
				
				if (isOk) {
					new Checkout(CurrentRepository.getInstance()
							.getRepository(), refList.get(0).getRef().getName());
					// new
					// AlertDialog("Checkout commit : "+commitList.get(0).getCommit().getName());
					WriteToPane.getInstance().write(
							"Checkout commit : "
									+ refList.get(0).getRef().getName()
									+ "\n", TextStyles.getInstance().ALERT);

					logger.info("repaint all begin");
					GrigitGraph.getInstance().repaintAll();
					logger.info("repaint all end");
					MainController.getInstance().repaint();
				} else {

				}
			} else {
				WriteToPane.getInstance().write(
						"You should select one commit or a branch\n",
						TextStyles.getInstance().ALERT);
				// new AlertDialog("You should select one commit or a branch");
			}

		} else {
			WriteToPane.getInstance().write(
					"You should select one commit or a branch\n",
					TextStyles.getInstance().ALERT);
		}

		// for test
		return 1;
	}

	public int createBranch() {

		// for test
		return 1;
	}
	
	public int merge(){

		if (!(commitList.isEmpty() && refList.isEmpty())){
			if(commitList.size()==2 && refList.isEmpty()){
				
			MergeDialog md = new MergeDialog(commitList.get(0).getCommit().getName(),
					commitList.get(1).getCommit().getName());
			boolean isOrder = md.isInOrder();
			if(isOrder){
				new Checkout(CurrentRepository.getInstance().getRepository(), commitList.get(0).getCommit().getName());
				new Merge(commitList.get(1).getCommit());
			} else {
				new Checkout(CurrentRepository.getInstance().getRepository(), commitList.get(1).getCommit().getName());
				new Merge(commitList.get(0).getCommit());
			}
			
				
			}else if(commitList.size()==1 && refList.size()==1){
				
				MergeDialog md = new MergeDialog(commitList.get(0).getCommit().getName(),
						refList.get(0).getRef().getName());
				boolean isOrder = md.isInOrder();
				if(isOrder){
					new Checkout(CurrentRepository.getInstance().getRepository(), commitList.get(0).getCommit().getName());
					new Merge(commitList.get(1).getCommit());
				} else {
					new Checkout(CurrentRepository.getInstance().getRepository(), commitList.get(1).getCommit().getName());
					new Merge(commitList.get(0).getCommit());
				}
				
				
			}else if(commitList.isEmpty() && refList.size()==2){
				
			}
			logger.info("repaint all begin");
			GrigitGraph.getInstance().repaintAll();
			logger.info("repaint all end");
			MainController.getInstance().repaint();
		} else {
			
			WriteToPane.getInstance().write(
					"You should select two nodes of the graph commit or branch\n",
					TextStyles.getInstance().ALERT);
			
		}
		
		
		return 1;
	}

}
