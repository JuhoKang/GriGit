package kr.re.ec.grigit.git;

import java.io.File;
import java.io.IOException;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class OpenRepository {
	
	
	private Repository repository;
	private Logger logger;
	
	/**
	 * Method getRepository.
	 * @return Repository
	 */
	public Repository getRepository() {
		return repository;
	}

	//don't need this
	/*
	public void setRepository(Repository repository) {
		this.repository = repository;
	}*/

	/**
	 * Constructor for OpenRepository.
	 * @param repositorydirectory String
	 */
	public OpenRepository(File repositorydirectory) {
		
		logger = LoggerFactory.getLogger(OpenRepository.class);
		
		try {
			core(repositorydirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method core.
	 * @param repodir String
	 * @throws IOException
	 */
	private void core(File repodir) throws IOException{
		
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
	    Repository repository = builder.setGitDir(repodir)
	    		.findGitDir() // scan up the file system tree
	            .readEnvironment() // scan environment GIT_* variables
	            .build();
	    Ref head = repository.getRef("refs/heads/master");
	    
	    if(head == null){
        	WriteToPane.getInstance().write("This is a Bare repo or not a Repo please open a proper repository\n\n",TextStyles.getInstance().ALERT);
        } else {
        	//System.out.println("Having repository: " + repository.getDirectory());
    	    logger.info("Having repository: " + repository.getDirectory());
    	    this.repository = repository;
    	    //testing part
    	    CurrentRepository.getInstance().setRepository(repository);
    	        	    
            logger.info("Ref of refs/heads/master: " + head);
    	    logger.info("repo path"+repodir.getName());
        }
	   
	    //should i close or not?
	    //repository.close();
		
	}
	
	
}
