package kr.re.ec.grigit.git;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Checkout {

	Logger logger;

	public Checkout(Repository repository, String name) {

		logger = LoggerFactory.getLogger(Checkout.class);
	
		try {
			checkoutBranch(repository, name);
		} catch (RefAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRefNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CheckoutConflictException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkoutBranch(Repository repository, String name)
			throws RefAlreadyExistsException, RefNotFoundException,
			InvalidRefNameException, CheckoutConflictException, GitAPIException, IOException {

		Git git = new Git(repository);
		
		logger.info("before checkout branch : " + repository.getBranch());
		
		
		git.checkout().setName(name).call();
		
		logger.info("after checkout branch: " + repository.getBranch());

	}
	
	public void checkoutByRelRef() {

	}

}
