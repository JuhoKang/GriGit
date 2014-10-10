package kr.re.ec.grigit.git;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

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
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (ConcurrentRefUpdateException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (CheckoutConflictException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (InvalidMergeHeadsException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (WrongRepositoryStateException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (NoMessageException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (GitAPIException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			}
		} else if (id instanceof Ref){
			try {
				core((Ref)id);
			} catch (NoHeadException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (ConcurrentRefUpdateException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (CheckoutConflictException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (InvalidMergeHeadsException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (WrongRepositoryStateException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (NoMessageException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
				e.printStackTrace();
			} catch (GitAPIException e) {
				WriteToPane.getInstance().writeErr(e.getMessage());
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
