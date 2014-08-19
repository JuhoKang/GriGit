package org.eclipse.jgit.pgm;

import java.util.ArrayList;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

@Command(common = true, usage = "usage_cherry-pick")
class CherryPick extends TextBuiltin{

	
	/*
	@Option(name = "--edit", aliases = { "-e" }, usage = "usage_editCommitMessage")
	private boolean editCommit = false;
	*/
	
	/*
	@Option(name = "-x", usage = "usage_IndicateCommitIsCheeryPicked")
	private boolean indicateCherryPick = false;
	*/
	
	/*
	 * what is -r ?
	 */
	
	/*
	 * --mainline parent-number
	 * -m
	 */
	
	/*
	 * --no-commit
	 * -n
	 */
	
	/*
	 * --signoff
	 * -n
	 */
	
	/*
	 * --gpg-sign[=<key-id>]
	 */
	
	/*
	 * --ff
	 */
	
	/*
	 * --allow-empty
	 */
	@Argument(required = true, index = 0, usage = "usage_upstreamname")
	private ArrayList<String> upstreams = new ArrayList<String>();
	
	@Override
	protected void run() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
