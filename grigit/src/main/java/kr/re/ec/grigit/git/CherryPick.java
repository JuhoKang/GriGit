package kr.re.ec.grigit.git;

import java.util.ArrayList;

import kr.re.ec.grigit.CurrentRepository;

import org.eclipse.jgit.api.CherryPickCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CherryPick {
	
	Logger logger;
	
	public CherryPick(ArrayList<AnyObjectId> commits){
		
		logger = LoggerFactory.getLogger(CherryPick.class);
		
		try {
			core(commits);
		} catch (NoMessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnmergedPathsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConcurrentRefUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void core(ArrayList<AnyObjectId> commits) throws NoMessageException, UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, NoHeadException, GitAPIException{
		
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		CherryPickCommand cherrypick = null;
		
		for (AnyObjectId commit : commits){
			cherrypick = git.cherryPick()
			.include(commit);
		}		
		cherrypick.call();
	}
	
	

}
