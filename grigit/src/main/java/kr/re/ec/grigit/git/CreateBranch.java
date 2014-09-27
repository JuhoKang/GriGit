package kr.re.ec.grigit.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;

import kr.re.ec.grigit.CurrentRepository;

public class CreateBranch {
	
	public CreateBranch(String name,String startPoint){
		
		try {
			core(name, startPoint);
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
	
	private void core(String name, String startPoint) throws RefAlreadyExistsException, RefNotFoundException, InvalidRefNameException, GitAPIException{
		
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		git.branchCreate()
		.setStartPoint(startPoint)
			.setName(name)
			.call();
		
	}
	

}
