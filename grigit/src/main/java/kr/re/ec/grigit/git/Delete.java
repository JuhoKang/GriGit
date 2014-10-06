package kr.re.ec.grigit.git;

import java.util.StringTokenizer;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.util.WriteToPane;

public class Delete {

	public Delete(String name) {

		try {
			core(name);
		} catch (GitAPIException e) {
			WriteToPane.getInstance().writeErr(e.getMessage());
			e.printStackTrace();
		}

	}

	public void core(String name) throws GitAPIException {
		Git git = new Git(CurrentRepository.getInstance().getRepository());

		System.out.println("deleting");

		StringTokenizer st = new StringTokenizer(name, "/");

		String tokens[] = name.split("/");
		String refName = null;
		if (name.contains("/remotes/")) {
			refName = tokens[tokens.length-2]+"/"+tokens[tokens.length-1];
		} else {
			refName = tokens[tokens.length-1];
		}

		if (name.contains("/tags/")) {
			System.out.println("delete tag");
			git.tagDelete().setTags(refName).call();
		} else {
			git.branchDelete().setBranchNames(name).setForce(true).call();
		}
		System.out.println("deleted " + refName);

	}

}
