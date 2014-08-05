package kr.ec.grigit.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class CreateNewRepository {

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
	 * Constructor for CreateNewRepository.
	 * @param reponame String
	 */
	public CreateNewRepository(String reponame) {

		logger = LoggerFactory.getLogger(GitInit.class);

		try {
			core(reponame);
		} catch (IOException e) {
			logger.info("I/O exception");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			logger.info("There is already a repository with that name or it might be a another problem");
			e.printStackTrace();
		}

	}

	/**
	 * Method core.
	 * @param reponame String
	 * @throws IOException
	 */
	private void core(String reponame) throws IOException {

		// prepare a new folder
		File localPath = new File("./git/" + reponame);
		localPath.delete();

		// create the directory
		Repository repository = FileRepositoryBuilder.create(new File(
				localPath, ".git"));
		repository.create();

		logger.info("Having repository: " + repository.getDirectory());

		repository.close();

	}
}