package kr.re.ec.git;

import java.io.IOException;

import kr.re.ec.CurrentRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class GitShowAllCommits {
	
	Logger logger;
	
	public GitShowAllCommits() {
		
		logger = LoggerFactory.getLogger(GitShowAllCommits.class);
		try {
			core();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method core.
	 * @throws NoHeadException
	 * @throws GitAPIException
	 * @throws IOException
	 */
	private void core() throws NoHeadException, GitAPIException, IOException{
	
		Repository repository = CurrentRepository.getInstance().getRepository();

        Git git = new Git(repository);
        Iterable<RevCommit> commits = git.log().all().call();
        int count = 0;
        for (RevCommit commit : commits) {
        	
			logger.info("LogCommit: Commit time : " + commit.getCommitTime()+"\n"
            		+ "Commit Author :" + commit.getAuthorIdent() +"\n"
            		+ "Commit Commiter :" + commit.getCommitterIdent() +"\n"
            		+ "Commit hash :" + commit.getId().getName() +"\n"
            		+ "Commit message :" + commit.getFullMessage() +"\n"
            		+ "Parent Count :" + commit.getParentCount() +"\n"
            	// the first commit doesn't have parent 
            	//	+ "Parent (commit^)" + commit.getParent(1) + "\n"
            		+"\n" );
            count++;
        }
        logger.info("count" + count);

        repository.close();
	}

}
