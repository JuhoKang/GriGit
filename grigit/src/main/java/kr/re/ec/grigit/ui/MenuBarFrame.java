package kr.re.ec.grigit.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarFrame extends JMenuBar{
	
	protected JMenuItem mntmOpenRepo;
	protected JMenuItem mntmHowtoUseCommand;
	protected JMenuItem mntmBranch;
	protected JMenuItem mntmMerge;
	
	protected JMenu mnFile;
	protected JMenu mnHelp;
	protected JMenu mnRepository;
	
	public MenuBarFrame() {
		
		mnFile = new JMenu("File");
		mnRepository = new JMenu("Repository");
		mnHelp = new JMenu("Help");
		
		
		add(mnFile);
		add(mnRepository);
		add(mnHelp);
		//clone commit chjeckout branch merge rebase merge
		mntmOpenRepo = new JMenuItem("Open Repository");
		mntmBranch = new JMenuItem("Branch");
		mntmMerge = new JMenuItem("Merge");
		mntmHowtoUseCommand = new JMenuItem("How to use Command?");
		
		mnFile.add(mntmOpenRepo);
		mnHelp.add(mntmHowtoUseCommand);
		mnRepository.add(mntmBranch);
		mnRepository.add(mntmMerge);
		
	}

}
