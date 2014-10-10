package kr.re.ec.grigit.git;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.util.WriteToPane;

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
		} catch (Exception e){
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void core(RevCommit commit,String name,String author, String email) throws ConcurrentRefUpdateException, InvalidTagNameException, NoHeadException, GitAPIException{
		
		
		Git git = new Git(CurrentRepository.getInstance().getRepository());
		
		git.tag().setTagger(new PersonIdent(author,email)).setObjectId(commit).setName(name).call();
		
	}
	
}
