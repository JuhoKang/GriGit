package kr.re.ec.grigit.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarFrame extends JMenuBar{
	
	protected JMenuItem mntmOpenRepo;
	protected JMenu mnFile;
	
	public MenuBarFrame() {
		
		mnFile = new JMenu("File");
		add(mnFile);
		
		mntmOpenRepo = new JMenuItem("Open Repository");
		mnFile.add(mntmOpenRepo);
	}

}
