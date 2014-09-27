package kr.re.ec.grigit.git;

import java.util.Set;

import kr.re.ec.grigit.CurrentRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.NoWorkTreeException;

public class GetModifiedFiles {

	private Set<String> addedFiles;
	private Set<String> changedFiles;
	private Set<String> missingFiles;
	private Set<String> modifiedFiles;
	private Set<String> removedFiles;
	private Set<String> untrackedFiles;

	public GetModifiedFiles() {
		try {
			core();
		} catch (NoWorkTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public Set<String> getAddedFiles() {
		return addedFiles;
	}

	public void setAddedFiles(Set<String> addedFiles) {
		this.addedFiles = addedFiles;
	}

	public Set<String> getChangedFiles() {
		return changedFiles;
	}

	public void setChangedFiles(Set<String> changedFiles) {
		this.changedFiles = changedFiles;
	}

	public Set<String> getMissingFiles() {
		return missingFiles;
	}

	public void setMissingFiles(Set<String> missingFiles) {
		this.missingFiles = missingFiles;
	}

	public Set<String> getRemovedFiles() {
		return removedFiles;
	}

	public void setRemovedFiles(Set<String> removedFiles) {
		this.removedFiles = removedFiles;
	}

	public Set<String> getUntrackedFiles() {
		return untrackedFiles;
	}

	public void setUntrackedFiles(Set<String> untrackedFiles) {
		this.untrackedFiles = untrackedFiles;
	}

	private void core() throws NoWorkTreeException, GitAPIException {
		Git git = new Git(CurrentRepository.getInstance().getRepository());

		addedFiles = git.status().call().getAdded();
		changedFiles = git.status().call().getChanged();
		missingFiles = git.status().call().getMissing();
		modifiedFiles = git.status().call().getModified();
		removedFiles = git.status().call().getRemoved();
		untrackedFiles = git.status().call().getUntracked();
	}

	public Set<String> getModifiedFiles() {
		return modifiedFiles;
	}

	public void setModifiedFiles(Set<String> modifiedFiles) {
		this.modifiedFiles = modifiedFiles;
	}

}
