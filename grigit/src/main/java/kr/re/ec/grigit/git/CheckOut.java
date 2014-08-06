package kr.re.ec.grigit.git;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckOut {

	Logger logger;

	public CheckOut(Repository repository, String branchname) {

		logger = LoggerFactory.getLogger(CheckOut.class);
	
		try {
			checkoutBranch(repository, branchname);
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

	public CheckOut(Repository repository, RevCommit startCommit) {

		logger = LoggerFactory.getLogger(CheckOut.class);

		try {
			checkoutCommit(repository, startCommit);
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

	public void checkoutBranch(Repository repository, String branchname)
			throws RefAlreadyExistsException, RefNotFoundException,
			InvalidRefNameException, CheckoutConflictException, GitAPIException, IOException {

		Git git = new Git(repository);
		
		logger.info("before checkout branch : " + repository.getBranch());
		
		
		git.checkout().setName(branchname).call();
		
		logger.info("after checkout branch: " + repository.getBranch());

	}

	public void checkoutCommit(Repository repository, RevCommit startCommit)
			throws RefAlreadyExistsException, RefNotFoundException,
			InvalidRefNameException, CheckoutConflictException, GitAPIException, IOException {

		Git git = new Git(repository);
		
		logger.info("before checkout branch : " + repository.getBranch());
		
		git.checkout().setStartPoint(startCommit).call();
		
				
		logger.info("after checkout branch: " + repository.getBranch());
	}

	public void checkoutByRelRef() {

	}

}
