package kr.re.ec.grigit.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidMergeHeadsException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revplot.PlotCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.jgraphx.test.ui.SwingCommitList.SwingLane;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

public class Merge {
	Logger logger;
	
	public Merge(Object id){
		
		logger = LoggerFactory.getLogger(Merge.class);
		WriteToPane.getInstance().write("Starting Merge\n", TextStyles.getInstance().PROGRESS);
		
		if(id instanceof PlotCommit<?>){
			try {
				logger.info("This is a PlotCommit");
				core((AnyObjectId)id);
			} catch (NoHeadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConcurrentRefUpdateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CheckoutConflictException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidMergeHeadsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WrongRepositoryStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoMessageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (id instanceof Ref){
			try {
				core((Ref)id);
			} catch (NoHeadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConcurrentRefUpdateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CheckoutConflictException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidMergeHeadsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WrongRepositoryStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoMessageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	private void core(AnyObjectId id) throws NoHeadException, ConcurrentRefUpdateException, CheckoutConflictException, InvalidMergeHeadsException, WrongRepositoryStateException, NoMessageException, GitAPIException{
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		git.merge().include(id).call();
		
		WriteToPane.getInstance().write("Merge Complete\n", TextStyles.getInstance().PROGRESS);
		WriteToPane.getInstance().write("The Head is now detached\n", TextStyles.getInstance().ALERT);
	}
	private void core(Ref ref) throws NoHeadException, ConcurrentRefUpdateException, CheckoutConflictException, InvalidMergeHeadsException, WrongRepositoryStateException, NoMessageException, GitAPIException{
Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		git.merge().include(ref).call();
		WriteToPane.getInstance().write("Merge Complete\n", TextStyles.getInstance().PROGRESS);
	}

}
