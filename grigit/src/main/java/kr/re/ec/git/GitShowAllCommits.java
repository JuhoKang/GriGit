package kr.re.ec.git;

import java.io.IOException;

import kr.re.ec.CurrentRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

public class GitShowAllCommits {
	
	public GitShowAllCommits() {
		// TODO Auto-generated constructor stub
	}
	
	private void core() throws NoHeadException, GitAPIException, IOException{
	
		Repository repository = CurrentRepository.getInstance().getRepository();

        Git git = new Git(repository);
        Iterable<RevCommit> commits = git.log().all().call();
        int count = 0;
        for (RevCommit commit : commits) {
            System.out.println("LogCommit: " + commit);
            count++;
        }
        System.out.println(count);

        repository.close();
	}

}
