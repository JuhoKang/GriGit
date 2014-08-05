package kr.ec.grigit.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * GitInit class<br>
 * parameters: String repository name<br>
 * 
 * Usage: init a repository with it's directory path<br>
 * 
 * @author Kang Juho
 * @version 1.0.0
 * 
 *
 */

public class GitInit {
	
	private String result;
	Logger logger;
	
	/**
	 * Method getResult.
	 * @return String
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Method setResult.
	 * @param result String
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Constructor for GitInit.
	 * @param path String
	 */
	public GitInit(String path) {
		
		logger = LoggerFactory.getLogger(GitInit.class);
		
		try {
			core(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method core.
	 * @param path String
	 * @throws IOException
	 * @throws GitAPIException
	 */
	private void core(String path) throws IOException, GitAPIException{

        File dir = new File(path);
        
        //for test
        //    dir.delete();

        Git.init()
                .setDirectory(dir)
                .call();

        Repository repository = FileRepositoryBuilder.create(new File(dir.getAbsolutePath(), ".git"));

        System.out.println("Created a new repository at " + repository.getDirectory());

        repository.close();
	}

}
