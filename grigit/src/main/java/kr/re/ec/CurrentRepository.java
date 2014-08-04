package kr.re.ec;

import org.eclipse.jgit.lib.Repository;

public class CurrentRepository {

	// for singleton
	private static CurrentRepository instance = null;

	// for singleton
	static {
		try {
			instance = new CurrentRepository();
		} catch (Exception e) {
			throw new RuntimeException("singleton instance intialize error");
		}
	}

	// for singleton
	private CurrentRepository() {

	}

	// for singleton
	public static CurrentRepository getInstance() {
		return instance;
	}

	private Repository repository;

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

}
