package kr.re.ec.grigit.git;

import kr.re.ec.grigit.CurrentRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

public class Rebase {
	
	public Rebase(AnyObjectId upstream){
		
		core(upstream);
	}
	
	private void core(AnyObjectId upstream){
		
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		try {
			rebaseUpstream(git, upstream);
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void rebaseUpstream(Git git, AnyObjectId upstream) throws NoHeadException, WrongRepositoryStateException, GitAPIException{
		git.rebase().setUpstream(upstream).call();
	}
	
	//todo
	public void rebaseInteractively(Git git){
		
		//git.rebase().runInteractively(handler);
		
	}
		

}
