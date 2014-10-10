package kr.re.ec.grigit.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBarFrame extends JMenuBar{
	
	protected JMenuItem mntmOpenRepo;
	protected JMenuItem mntmHowtoUseCommand;
	
	protected JMenuItem mntmCommit;
	protected JMenuItem mntmCheckout;
	protected JMenuItem mntmBranch;
	protected JMenuItem mntmMerge;
	protected JMenuItem mntmRebase;
	protected JMenuItem mntmCherry_Pick;
	
	protected JMenu mnFile;
	protected JMenu mnHelp;
	protected JMenu mnRepository;
	protected JMenuItem mntmUserSetting;
	protected JMenuItem mntmAbout;
	protected JMenuItem mntmTag;
	protected JMenuItem mntmDelete;
	
	public MenuBarFrame() {
		
		mnFile = new JMenu("File");
		mnRepository = new JMenu("Repository");
		mnHelp = new JMenu("Help");
		
		
		add(mnFile);
		add(mnRepository);
		add(mnHelp);
		//clone commit chjeckout branch merge rebase merge
		mntmOpenRepo = new JMenuItem("Open Repository");
		mntmCommit = new JMenuItem("Commit");
		mntmCheckout = new JMenuItem("Checkout");
		mntmBranch = new JMenuItem("Branch");
		mntmMerge = new JMenuItem("Merge");
		mntmRebase = new JMenuItem("Rebase");
		mntmCherry_Pick = new JMenuItem("Cherry-Pick");
		
		
		
		mntmHowtoUseCommand = new JMenuItem("How to use Command?");
		
		
		mnFile.add(mntmOpenRepo);
		
		mnRepository.add(mntmCommit);
		mnRepository.add(mntmCheckout);
		mnRepository.add(mntmBranch);
		mnRepository.add(mntmMerge);
		mnRepository.add(mntmRebase);
		mnRepository.add(mntmCherry_Pick);
		
		mntmTag = new JMenuItem("Tag");
		mnRepository.add(mntmTag);
		
		mntmDelete = new JMenuItem("Delete");
		mnRepository.add(mntmDelete);
		
		mnHelp.add(mntmHowtoUseCommand);
		
		mntmUserSetting = new JMenuItem("User Setting");
		mnHelp.add(mntmUserSetting);
		
		mntmAbout = new JMenuItem("about Grigit....");
		mnHelp.add(mntmAbout);
	}
}
