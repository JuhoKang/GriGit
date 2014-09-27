package kr.re.ec.grigit.git;

import kr.re.ec.grigit.CurrentRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidTagNameException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;

public class CreateTag {

	public CreateTag(RevCommit commit,String name,String author, String email){
		
		try {
			core(commit, name, author, email);
		} catch (ConcurrentRefUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTagNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void core(RevCommit commit,String name,String author, String email) throws ConcurrentRefUpdateException, InvalidTagNameException, NoHeadException, GitAPIException{
		
		
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		git.tag().setTagger(new PersonIdent(author,email)).setObjectId(commit).setName(name).call();
		
	}
	
}
