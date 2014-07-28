package kr.re.ec.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class OpenRepository {
	
	private Repository repository;
	
	public Repository getRepository() {
		return repository;
	}

	//don't need this
	/*
	public void setRepository(Repository repository) {
		this.repository = repository;
	}*/

	public OpenRepository(String repositorydirectory) {
		
		try {
			core(repositorydirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void core(String repodir) throws IOException{
		
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
	    Repository repository = builder.setGitDir(new File(repodir))
	            .readEnvironment() // scan environment GIT_* variables
	            .findGitDir() // scan up the file system tree
	            .build();

	    System.out.println("Having repository: " + repository.getDirectory());
	    
	    this.repository = repository;
	    //should i close or not?
	    repository.close();
		
	}
	
	
}
