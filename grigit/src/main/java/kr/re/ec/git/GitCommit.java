package kr.re.ec.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.lib.Repository;

public class GitCommit {
	
	public GitCommit(){
		
	}

	private void core(Repository repository) throws IOException, NoFilepatternException, GitAPIException{
		
		

	        Git git = new Git(repository);

	        // create the file
	        File myfile = new File(repository.getDirectory().getParent(), "testfile");
	        myfile.createNewFile();

	        // run the add
	        git.add()
	                .addFilepattern("testfile")
	                .call();

	        // and then commit the changes
	        git.commit()
	                .setMessage("Added testfile")
	                .call();

	        System.out.println("Committed file " + myfile + " to repository at " + repository.getDirectory());

	        repository.close();
		
	}
}
