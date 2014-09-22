package kr.re.ec.grigit.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarFrame extends JMenuBar{
	
	protected JMenuItem mntmOpenRepo;
	protected JMenuItem mntmHowtoUseCommand;
	
	protected JMenu mnFile;
	protected JMenu mnCommand;
	
	public MenuBarFrame() {
		
		mnFile = new JMenu("File");
		mnCommand = new JMenu("Command");
		
		add(mnFile);
		add(mnCommand);
		//clone commit chjeckout branch merge rebase merge
		mntmOpenRepo = new JMenuItem("Open Repository");
		mntmHowtoUseCommand = new JMenuItem("How to use Command?");
		mnFile.add(mntmOpenRepo);
		mnCommand.add(mntmHowtoUseCommand);
	}

}
