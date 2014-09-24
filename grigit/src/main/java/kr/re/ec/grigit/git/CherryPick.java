package kr.re.ec.grigit.git;

import java.util.ArrayList;

import org.eclipse.jgit.api.CherryPickCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CherryPick {
	
	Logger logger;
	
	public CherryPick(Repository repository, ArrayList<RevCommit> commits){
		
		logger = LoggerFactory.getLogger(CherryPick.class);
		
		try {
			core(repository, commits);
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
	
	private void core(Repository repository, ArrayList<RevCommit> commits) throws NoMessageException, UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, NoHeadException, GitAPIException{
		
		Git git = new Git(repository);
		CherryPickCommand cherrypick = null;
		
		for (RevCommit commit : commits){
			cherrypick = git.cherryPick()
			.include(commit.getId());
		}		
		cherrypick.call();
	}
	
	

}
