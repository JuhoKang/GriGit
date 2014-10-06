package kr.re.ec.grigit.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.util.WriteToPane;

public class CreateBranch {
	
	public CreateBranch(String name,String startPoint){
		
		try {
			core(name, startPoint);
		} catch (RefAlreadyExistsException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (InvalidRefNameException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		} catch (GitAPIException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
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
