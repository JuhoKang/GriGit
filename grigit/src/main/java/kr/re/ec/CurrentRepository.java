package kr.re.ec;

import org.eclipse.jgit.lib.Repository;

public class CurrentRepository {

	private static Repository repository;

	public static Repository getRepository() {
		return repository;
	}

	public static void setRepository(Repository repository) {
		CurrentRepository.repository = repository;
	}
	
}
