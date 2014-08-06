package kr.re.ec.grigit.test.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.CheckOut;
import kr.re.ec.grigit.git.OpenRepository;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CherryPickTest {
	
	public static void main(String[] args) {
		
		List<DiffEntry> difflist = null;
		Logger logger = LoggerFactory.getLogger(CherryPickTest.class);
	
		new OpenRepository(new File("E:/BiBim/.git"));
		
		Repository currentrepo = CurrentRepository.getInstance().getRepository();
		
		new CheckOut(currentrepo, "juho");
		
	
	    Git git = new Git(currentrepo);
	 
	    String oldHash = "64ac345d62265b";
	 
	    ObjectId headId = null;
		try {
			headId = git.getRepository().resolve("HEAD^{tree}");
		} catch (RevisionSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmbiguousObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectObjectTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ObjectId oldId = null;
		try {
			oldId = git.getRepository().resolve(oldHash + "^{tree}");
		} catch (RevisionSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmbiguousObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectObjectTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    ObjectReader reader = git.getRepository().newObjectReader();
	     
	    CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
	    try {
			oldTreeIter.reset(reader, oldId);
		} catch (IncorrectObjectTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
	    try {
			newTreeIter.reset(reader, headId);
		} catch (IncorrectObjectTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    List<DiffEntry> diffs = null;
		try {
			diffs = git.diff()
			        .setNewTree(newTreeIter)
			        .setOldTree(oldTreeIter)
			        .call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    DiffFormatter df = new DiffFormatter(out);
	    df.setRepository(git.getRepository());
	 
	    for(DiffEntry diff : diffs)
	    {
	      try {
			df.format(diff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      diff.getOldId();
	      String diffText = null;
		try {
			diffText = out.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(diffText);
	      out.reset();
	    }
		
	}

}
