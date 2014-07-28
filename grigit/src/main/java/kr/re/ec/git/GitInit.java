package kr.re.ec.git;

import java.io.File;
import java.io.IOException;

import kr.re.ec.test.ui.TestFrame;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GitInit {
	
	public GitInit() throws IOException{
		
		Logger logger = LoggerFactory.getLogger(GitInit.class);
		
		// prepare a new folder
		File localPath = new File("./git/test");
	    localPath.delete();

	    // create the directory
	    Repository repository = FileRepositoryBuilder.create(new File(localPath, ".git"));
	    repository.create();

	    logger.debug("Having repository: " + repository.getDirectory());
	    logger.info("Having repository: " + repository.getDirectory());

	    repository.close();
		
	}

}
