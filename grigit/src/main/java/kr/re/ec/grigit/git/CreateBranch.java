package kr.re.ec.grigit.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;

import kr.re.ec.grigit.CurrentRepository;

public class CreateBranch {
	
	CreateBranch(String name){
		
		try {
			core(name);
		} catch (RefAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRefNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void core(String name) throws RefAlreadyExistsException, RefNotFoundException, InvalidRefNameException, GitAPIException{
		
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		git.branchCreate()
			.setName(name)
			.call();
		
	}
	

}
