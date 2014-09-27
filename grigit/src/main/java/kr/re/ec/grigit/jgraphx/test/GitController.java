package kr.re.ec.grigit.jgraphx.test;

import java.util.ArrayList;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.Checkout;
import kr.re.ec.grigit.git.CreateBranch;
import kr.re.ec.grigit.git.GetModifiedFiles;
import kr.re.ec.grigit.git.GitCommit;
import kr.re.ec.grigit.git.Merge;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.jgraphx.test.ui.NodeCommit;
import kr.re.ec.grigit.jgraphx.test.ui.NodeRef;
import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;
import kr.re.ec.grigit.ui.CheckoutCheckDialogFrame;
import kr.re.ec.grigit.ui.CommitDialogFrame;
import kr.re.ec.grigit.ui.MergeDialogFrame;
import kr.re.ec.grigit.ui.controller.CheckoutCheckDialogController;
import kr.re.ec.grigit.ui.controller.CommitDialog;
import kr.re.ec.grigit.ui.controller.CreateBranchDialog;
import kr.re.ec.grigit.ui.controller.MainController;
import kr.re.ec.grigit.ui.controller.MergeDialog;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revplot.PlotCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitController {

	ArrayList<NodeCommit> commitList;
	ArrayList<NodeRef> refList;

	String commithead = "commit :";
	String branchhead = "branch :";
	String committag = "commit message : <br>";
	String branchtag = "branch name : <br>";

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
	
	public int cherryPick(){
		
		
		
		return 1;
	}
	
	
	public int commit(){
		
		GetModifiedFiles gmf = new GetModifiedFiles();
		CommitDialog cd = new CommitDialog(gmf.getAddedFiles(),gmf.getChangedFiles(),
				gmf.getMissingFiles(),gmf.getModifiedFiles(),gmf.getRemovedFiles(),gmf.getUntrackedFiles());
		if(!cd.isCancel()){
			
			new GitCommit(cd.getCheckedFileList(),cd.getCommitMessage());
			logger.info("repaint all begin");
			GrigitGraph.getInstance().repaintAll();
			logger.info("repaint all end");
			MainController.getInstance().repaint();
		}else{

		}
		
		return 1;
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
									+ refList.get(0).getRef().getName() + "\n",
							TextStyles.getInstance().ALERT);

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
		
		if (!(commitList.isEmpty() && refList.isEmpty())) {
			if(commitList.size()==1 && refList.isEmpty()){
				CreateBranchDialog cbd = new CreateBranchDialog("commit:"+commitList.get(0).getCommit().getName());
				if(!cbd.isCancel()){
					new CreateBranch(cbd.getBranchName(),commitList.get(0).getCommit().getName());	
					
				}
			} else if(refList.size()==1 && commitList.isEmpty()){
				CreateBranchDialog cbd = new CreateBranchDialog("branch:"+refList.get(0).getRef().getName());
				if(!cbd.isCancel()){
					new CreateBranch(cbd.getBranchName(),refList.get(0).getRef().getName());	
				}
			} else {
				WriteToPane.getInstance().write(
						"You should select one commit or a branch\n",
						TextStyles.getInstance().ALERT);
			}
			logger.info("repaint all begin");
			GrigitGraph.getInstance().repaintAll();
			logger.info("repaint all end");
			MainController.getInstance().repaint();
			
		} else {
			WriteToPane.getInstance().write(
					"You should select one commit or a branch\n",
					TextStyles.getInstance().ALERT);
		}
		

		// for test
		return 1;
	}

	public int merge() {

		if (!(commitList.isEmpty() && refList.isEmpty())) {
			if (commitList.size() == 2 && refList.isEmpty()) {
				PlotCommit<SwingLane> firstCommit = commitList.get(0)
						.getCommit();
				PlotCommit<SwingLane> secondCommit = commitList.get(1)
						.getCommit();
				MergeDialog md = new MergeDialog(commithead
						+ firstCommit.getName(), committag
						+ firstCommit.getShortMessage(), commithead
						+ secondCommit.getName(), committag
						+ secondCommit.getShortMessage());
				boolean isOrder = md.isInOrder();

				if (!md.isCancel()) {
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), firstCommit.getName());
						new Merge(secondCommit);
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), secondCommit.getName());
						new Merge(firstCommit);
					}
				} else {
					WriteToPane.getInstance().write(
							"Merge Canceled\n",
							TextStyles.getInstance().PROGRESS);
				}

			} else if (commitList.size() == 1 && refList.size() == 1) {
				PlotCommit<SwingLane> commit = commitList.get(0).getCommit();
				Ref ref = refList.get(0).getRef();
				MergeDialog md = new MergeDialog(commithead + commit.getName(),
						committag + commit.getShortMessage(), branchhead
								+ ref.getName(), branchtag + ref.getName());
				boolean isOrder = md.isInOrder();

				if (!md.isCancel()) {
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), commit.getName());
						new Merge(ref);
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), ref.getName());
						new Merge(commit);
					}

				} else {
					WriteToPane.getInstance().write(
							"Merge Canceled\n",
							TextStyles.getInstance().PROGRESS);
				}

			} else if (commitList.isEmpty() && refList.size() == 2) {
				Ref firstRef = refList.get(0).getRef();
				Ref secondRef = refList.get(1).getRef();
				MergeDialog md = new MergeDialog(branchhead
						+ firstRef.getName(), branchtag + firstRef.getName(),
						branchhead + secondRef.getName(), branchtag
								+ secondRef.getName());
				boolean isOrder = md.isInOrder();
				if(!md.isCancel()){
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), firstRef.getName());
						new Merge(secondRef);
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), secondRef.getName());
						new Merge(firstRef);
					}
				} else{
					WriteToPane.getInstance().write(
							"Merge Canceled\n",
							TextStyles.getInstance().PROGRESS);
				}
				
			}
			logger.info("repaint all begin");
			GrigitGraph.getInstance().repaintAll();
			logger.info("repaint all end");
			MainController.getInstance().repaint();
		} else {

			WriteToPane
					.getInstance()
					.write("You should select two nodes of the graph commit or branch\n",
							TextStyles.getInstance().ALERT);

		}

		return 1;
	}

}
