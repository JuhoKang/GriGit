package kr.re.ec.grigit.git;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.util.WriteToPane;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.lib.Repository;

/**
 */
public class GitCommit {
	
	public GitCommit(ArrayList<String> fileList, String message, String author, String email){
		try {
			core(fileList, message, author, email);
		} catch (NoFilepatternException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (GitAPIException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Method core.
	 * @param repository Repository
	 * @throws IOException
	 * @throws NoFilepatternException
	 * @throws GitAPIException
	 */
	private void core(ArrayList<String> fileList,String message,String author, String email) throws IOException, NoFilepatternException, GitAPIException{
		
		

	        Git git = new Git(CurrentRepository.getInstance().getRepository());

	        
	        for(String file : fileList){
	        	git.add()
                .addFilepattern(file)
                .call();
	        }
	        

	        // and then commit the changes
	        git.commit()
	        .setAuthor(author, email)
	                .setMessage(message)
	                .call();
		
	}
}
