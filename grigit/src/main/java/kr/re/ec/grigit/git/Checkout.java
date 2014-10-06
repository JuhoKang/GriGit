package kr.re.ec.grigit.git;

import java.io.IOException;

import kr.re.ec.grigit.util.WriteToPane;

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
//change
	public Checkout(Repository repository, String name) {

		logger = LoggerFactory.getLogger(Checkout.class);
	
		try {
			checkoutBranch(repository, name);
		} catch (RefAlreadyExistsException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (InvalidRefNameException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (CheckoutConflictException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (GitAPIException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
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
