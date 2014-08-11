package kr.re.ec.grigit.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

public class Rebase {
	
	public Rebase(){
		
	}
	
	public void core(Repository repository){
		
		Git git = new Git(repository);
		
	}
	
	private void rebaseUpstream(Git git, String upstream) throws RefNotFoundException{
		git.rebase().setUpstream(upstream);
	}
	private void rebaseUpstream(Git git, RevCommit upstream) throws RefNotFoundException{
		git.rebase().setUpstream(upstream);
	}
	private void rebaseUpstream(Git git, AnyObjectId upstream) throws RefNotFoundException{
		
	}
	
	//todo
	public void rebaseInteractively(Git git){
		
		//git.rebase().runInteractively(handler);
		
	}
		

}
