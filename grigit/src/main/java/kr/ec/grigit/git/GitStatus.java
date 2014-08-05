package kr.ec.grigit.git;

import java.util.ArrayList;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class GitStatus {
	
	Logger logger;
	
	/**
	 * Constructor for GitStatus.
	 * @param repository Repository
	 */
	public GitStatus(Repository repository){
		
		logger = LoggerFactory.getLogger(GitStatus.class);
		
		try {
			core(repository);
		} catch (NoWorkTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method core.
	 * @param repository Repository
	 * @return ArrayList<String>
	 * @throws NoWorkTreeException
	 * @throws GitAPIException
	 */
	private ArrayList<String> core(Repository repository) throws NoWorkTreeException, GitAPIException{

		ArrayList<String> statuslog = new ArrayList<String>();
		
	    Status status = new Git(repository).status().call();
	    
	    statuslog.add("Added: " + status.getAdded());
	    statuslog.add("Changed: " + status.getChanged());
	    statuslog.add("Conflicting: " + status.getConflicting());
	    statuslog.add("ConflictingStageState: " + status.getConflictingStageState());
	    statuslog.add("IgnoredNotInIndex: " + status.getIgnoredNotInIndex());
	    statuslog.add("Missing: " + status.getMissing());
	    statuslog.add("Modified: " + status.getModified());
	    statuslog.add("Removed: " + status.getRemoved());
	    statuslog.add("Untracked: " + status.getUntracked());
	    statuslog.add("UntrackedFolders: " + status.getUntrackedFolders());
		 
	    for(String e : statuslog){
	    	
	    	logger.info(e);    	
	    }
	    
	    return statuslog;
	}
	
}
