package kr.re.ec.grigit.graph.handler;

import java.util.ArrayList;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.UserInfo;
import kr.re.ec.grigit.git.Checkout;
import kr.re.ec.grigit.git.CherryPick;
import kr.re.ec.grigit.git.CreateBranch;
import kr.re.ec.grigit.git.CreateTag;
import kr.re.ec.grigit.git.Delete;
import kr.re.ec.grigit.git.GetModifiedFiles;
import kr.re.ec.grigit.git.GitCommit;
import kr.re.ec.grigit.git.Merge;
import kr.re.ec.grigit.git.Rebase;
import kr.re.ec.grigit.graph.ui.GrigitGraph;
import kr.re.ec.grigit.graph.ui.NodeCommit;
import kr.re.ec.grigit.graph.ui.NodeRef;
import kr.re.ec.grigit.graph.ui.SwingCommitList.SwingLane;
import kr.re.ec.grigit.ui.controller.CheckoutCheckDialogController;
import kr.re.ec.grigit.ui.controller.CherryPickDialog;
import kr.re.ec.grigit.ui.controller.CommitDialog;
import kr.re.ec.grigit.ui.controller.CreateBranchDialog;
import kr.re.ec.grigit.ui.controller.DeleteCheckDialog;
import kr.re.ec.grigit.ui.controller.MainController;
import kr.re.ec.grigit.ui.controller.MergeDialog;
import kr.re.ec.grigit.ui.controller.RebaseDialog;
import kr.re.ec.grigit.ui.controller.TagInputDialog;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.eclipse.jgit.lib.AnyObjectId;
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
	
	public int rebase() {
		
		if (!(commitList.isEmpty() && refList.isEmpty())) {
			if (commitList.size() == 2 && refList.isEmpty()) {
				PlotCommit<SwingLane> firstCommit = commitList.get(0)
						.getCommit();
				PlotCommit<SwingLane> secondCommit = commitList.get(1)
						.getCommit();
				RebaseDialog rd = new RebaseDialog(commithead
						+ firstCommit.getName(), committag
						+ firstCommit.getShortMessage(), commithead
						+ secondCommit.getName(), committag
						+ secondCommit.getShortMessage());
				boolean isOrder = rd.isInOrder();

				if (!rd.isCancel()) {
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), firstCommit.getName());
						new Rebase(secondCommit.getId());
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), secondCommit.getName());
						new Rebase(firstCommit.getId());
					}
				} else {
					WriteToPane.getInstance().write("Rebase Canceled\n",
							TextStyles.getInstance().PROGRESS);
				}

			} else if (commitList.size() == 1 && refList.size() == 1) {
				PlotCommit<SwingLane> commit = commitList.get(0).getCommit();
				Ref ref = refList.get(0).getRef();
				RebaseDialog rd = new RebaseDialog(commithead + commit.getName(),
						committag + commit.getShortMessage(), branchhead
								+ ref.getName(), branchtag + ref.getName());
				boolean isOrder = rd.isInOrder();

				if (!rd.isCancel()) {
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), commit.getName());
						new Rebase(ref.getObjectId());
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), ref.getName());
						new Rebase(commit.getId());
					}

				} else {
					WriteToPane.getInstance().write("Rebase Canceled\n",
							TextStyles.getInstance().PROGRESS);
				}

			} else if (commitList.isEmpty() && refList.size() == 2) {
				Ref firstRef = refList.get(0).getRef();
				Ref secondRef = refList.get(1).getRef();
				RebaseDialog rd = new RebaseDialog(branchhead
						+ firstRef.getName(), branchtag + firstRef.getName(),
						branchhead + secondRef.getName(), branchtag
								+ secondRef.getName());
				boolean isOrder = rd.isInOrder();
				if (!rd.isCancel()) {
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), firstRef.getName());
						new Rebase(secondRef.getObjectId());
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), secondRef.getName());
						new Rebase(firstRef.getObjectId());
					}
				} else {
					WriteToPane.getInstance().write("Rebase Canceled\n",
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
					.write("You should select two nodes of the graph which is commit or branch\n",
							TextStyles.getInstance().ALERT);

		}

		
		return 1;
	}

	public int delete() {

		if (!(commitList.isEmpty() && refList.isEmpty())) {

			if (refList.size() == 1 && commitList.isEmpty()) {

				String refName = refList.get(0).getRef().getName();
				DeleteCheckDialog dcd = new DeleteCheckDialog(refName);
				if (dcd.isOk()) {
					new Delete(refName);

					logger.info("repaint all begin");
					GrigitGraph.getInstance().repaintAll();
					logger.info("repaint all end");
					MainController.getInstance().repaint();
				} else {

				}

			} else {

				WriteToPane.getInstance().write(
						"Select a tag or branch you want to delete\n",
						TextStyles.getInstance().ALERT);

			}

		} else {

			WriteToPane.getInstance().write(
					"Select a tag or branch you want to delete\n",
					TextStyles.getInstance().ALERT);

		}

		return 1;

	}

	public int cherryPick() {

		if (!(commitList.isEmpty() && refList.isEmpty())) {

			CherryPickDialog cpd = new CherryPickDialog();
			if (cpd.isOk()) {
				ArrayList<AnyObjectId> idList = new ArrayList<AnyObjectId>();

				for (NodeRef ref : refList) {
					idList.add(ref.getRef().getObjectId());
				}

				for (NodeCommit commit : commitList) {
					idList.add(commit.getCommit().getId());
				}
				new CherryPick(idList);
				logger.info("repaint all begin");
				GrigitGraph.getInstance().repaintAll();
				logger.info("repaint all end");
				MainController.getInstance().repaint();
			} else {

			}

		} else {
			WriteToPane.getInstance().write(
					"Select the commits you want to cherry-pick\n",
					TextStyles.getInstance().ALERT);
		}

		return 1;
	}

	public int createTag() {

		ArrayList<String> author = userInfoReader();

		if (!(commitList.isEmpty() && refList.isEmpty())) {
			if (commitList.size() == 1 && refList.isEmpty()) {
				TagInputDialog tid = new TagInputDialog();
				if (tid.isOk()) {
					new CreateTag(commitList.get(0).getCommit(), tid.getName(),
							author.get(0), author.get(1));
					logger.info("repaint all begin");
					GrigitGraph.getInstance().repaintAll();
					logger.info("repaint all end");
					MainController.getInstance().repaint();
				} else {

				}

			} else {
				WriteToPane.getInstance().write(
						"Select a commit you want to tag\n",
						TextStyles.getInstance().ALERT);
			}
		} else {
			WriteToPane.getInstance().write(
					"Select a commit you want to tag\n",
					TextStyles.getInstance().ALERT);
		}

		// new CreateTag(commit, name, author, email)

		return 1;
	}

	public int commit() {

		GetModifiedFiles gmf = new GetModifiedFiles();
		CommitDialog cd = new CommitDialog(gmf.getAddedFiles(),
				gmf.getChangedFiles(), gmf.getMissingFiles(),
				gmf.getModifiedFiles(), gmf.getRemovedFiles(),
				gmf.getUntrackedFiles());
		if (!cd.isCancel()) {
			ArrayList<String> author = userInfoReader();
			new GitCommit(cd.getCheckedFileList(), cd.getCommitMessage(),
					author.get(0), author.get(1));
			logger.info("repaint all begin");
			GrigitGraph.getInstance().repaintAll();
			logger.info("repaint all end");
			MainController.getInstance().repaint();
		} else {

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
			if (commitList.size() == 1 && refList.isEmpty()) {
				CreateBranchDialog cbd = new CreateBranchDialog("commit:"
						+ commitList.get(0).getCommit().getName());
				if (!cbd.isCancel()) {
					new CreateBranch(cbd.getBranchName(), commitList.get(0)
							.getCommit().getName());

				}
			} else if (refList.size() == 1 && commitList.isEmpty()) {
				CreateBranchDialog cbd = new CreateBranchDialog("branch:"
						+ refList.get(0).getRef().getName());
				if (!cbd.isCancel()) {
					new CreateBranch(cbd.getBranchName(), refList.get(0)
							.getRef().getName());
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
					WriteToPane.getInstance().write("Merge Canceled\n",
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
					WriteToPane.getInstance().write("Merge Canceled\n",
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
				if (!md.isCancel()) {
					if (isOrder) {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), firstRef.getName());
						new Merge(secondRef);
					} else {
						new Checkout(CurrentRepository.getInstance()
								.getRepository(), secondRef.getName());
						new Merge(firstRef);
					}
				} else {
					WriteToPane.getInstance().write("Merge Canceled\n",
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
					.write("You should select two nodes of the graph which is commit or branch\n",
							TextStyles.getInstance().ALERT);

		}

		return 1;
	}

	private ArrayList<String> userInfoReader() {
		
		ArrayList<String> userInfo = new ArrayList<String>();
		userInfo.add(UserInfo.getInstance().getAuthor());
		userInfo.add(UserInfo.getInstance().getEmail());
		
		return userInfo;
	}

}
