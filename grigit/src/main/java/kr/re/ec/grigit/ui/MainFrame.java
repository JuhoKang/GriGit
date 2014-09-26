package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import kr.re.ec.grigit.ui.controller.MenuBarController;
import kr.re.ec.grigit.ui.controller.UserSettingController;

/**
 * MainFrame class for the Main Window of grigit
 * 
 * @version 1.0.1
 * @author Juho Kang, Sunghyeok Park
 */

@SuppressWarnings("serial")
public abstract class MainFrame extends JFrame{
	
	/*
	public JTextArea getTaLog() {
		return taLog;
	}
*/
	public JTextPane getTpLog() {
		return tpLog;
	}
	public StyledDocument getDoc(){
		return doc;
	}
	
	protected JButton btnOpen;
	protected JButton btnCommit;
	protected JButton btnCheckout;
	protected JButton btnBranch;
	protected JButton btnMerge;
	protected JButton btnRebase;
	protected JButton btnCherry_Pick;
	protected JButton btnTag;
	protected JButton btnUser_Setting;
	private JPanel panel;
	protected JTextField jtfCommandLine;
	private JScrollPane spLog;
	//private JTextArea taLog;
	protected JTextPane tpLog;
	protected StyledDocument doc;
	protected JScrollPane jspPG;
	protected JPanel jpPaintGit;
	
	
	public JPanel getJpPaintGit() {
		return jpPaintGit;
	}
	public void setJpPaintGit(JPanel jpPaintGit) {
		this.jpPaintGit = jpPaintGit;
	}
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel jpToolBar = new JPanel();
		getContentPane().add(jpToolBar, BorderLayout.NORTH);
		GridBagLayout gbl_jpToolBar = new GridBagLayout();
		gbl_jpToolBar.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jpToolBar.rowHeights = new int[]{0, 0};
		gbl_jpToolBar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpToolBar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jpToolBar.setLayout(gbl_jpToolBar);
		
		
		//Get img resources
		ImageIcon imgicOpen = new ImageIcon("target/classes/Open.png");
		ImageIcon imgicCommit = new ImageIcon("target/classes/Commit.png");
		ImageIcon imgicCheckout = new ImageIcon("target/classes/Checkout.png");
		ImageIcon imgicBranch = new ImageIcon("target/classes/Branch.png");
		ImageIcon imgicMerge = new ImageIcon("target/classes/Merge.png");
		ImageIcon imgicRebase = new ImageIcon("target/classes/Rebase.png");
		ImageIcon imgicCherry_Pick = new ImageIcon("target/classes/Cherry_Pick.png");
		ImageIcon imgicTag = new ImageIcon("target/classes/Tag.png");
		ImageIcon imgicUser_Setting= new ImageIcon("target/classes/UserSetting.png");
		
		jpToolBar.setBackground(Color.white);
		
		btnOpen = new JButton(imgicOpen);
		GridBagConstraints gbc_btnOpen= new GridBagConstraints();
		//gbc_btnOpen.insets = new Insets(0, 0, 0, 10);
		gbc_btnOpen.gridx = 0;
		gbc_btnOpen.gridy = 0;
		jpToolBar.add(btnOpen, gbc_btnOpen);
		
		btnCommit = new JButton(imgicCommit);
		GridBagConstraints gbc_btnCommit = new GridBagConstraints();
		//gbc_btnCommit.insets = new Insets(0, 0, 0, 10);
		gbc_btnCommit.gridx = 1;
		gbc_btnCommit.gridy = 0;
		jpToolBar.add(btnCommit, gbc_btnCommit);
		
		btnCheckout = new JButton(imgicCheckout);
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		//gbc_btnCheckout.insets = new Insets(0, 0, 0, 10);
		gbc_btnCheckout.gridx = 2;
		gbc_btnCheckout.gridy = 0;
		jpToolBar.add(btnCheckout, gbc_btnCheckout);
		
		btnBranch = new JButton(imgicBranch);
		GridBagConstraints gbc_btnBranch = new GridBagConstraints();
		//gbc_btnBranch.insets = new Insets(0, 0, 0, 10);
		gbc_btnBranch.gridx = 3;
		gbc_btnBranch.gridy = 0;
		jpToolBar.add(btnBranch, gbc_btnBranch);
		
		btnMerge = new JButton(imgicMerge);
		GridBagConstraints gbc_btnMerge = new GridBagConstraints();
		//gbc_btnMerge.insets = new Insets(0, 0, 0, 10);
		gbc_btnMerge.gridx = 4;
		gbc_btnMerge.gridy = 0;
		jpToolBar.add(btnMerge, gbc_btnMerge);
		
		btnRebase = new JButton(imgicRebase);
		GridBagConstraints gbc_btnRebase = new GridBagConstraints();
		//gbc_btnRebase.insets = new Insets(0, 0, 0, 10);
		gbc_btnRebase.gridx = 5;
		gbc_btnRebase.gridy = 0;
		jpToolBar.add(btnRebase, gbc_btnRebase);
		
		btnCherry_Pick = new JButton(imgicCherry_Pick);
		GridBagConstraints gbc_btnCherry_Pick = new GridBagConstraints();
		//gbc_btnCherry_Pick.insets = new Insets(0, 0, 0, 10);
		gbc_btnCherry_Pick.gridx = 6;
		gbc_btnCherry_Pick.gridy = 0;
		jpToolBar.add(btnCherry_Pick, gbc_btnCherry_Pick);
		
		btnTag = new JButton(imgicTag);
		GridBagConstraints gbc_btnTag = new GridBagConstraints();
		//gbc_btnTag.insets = new Insets(0, 0, 0, 10);
		gbc_btnTag.gridx = 7;
		gbc_btnTag.gridy = 0;
		jpToolBar.add(btnTag, gbc_btnTag);
		
		btnUser_Setting = new JButton(imgicUser_Setting);
		GridBagConstraints gbc_btnUser_Setting = new GridBagConstraints();
		//gbc_btnUser_Setting.insets = new Insets(0, 0, 0, 10);
		gbc_btnUser_Setting.gridx = 8;
		gbc_btnUser_Setting.gridy = 0;
		jpToolBar.add(btnUser_Setting, gbc_btnUser_Setting);
		
		btnOpen.setBackground(Color.white);
		btnOpen.setBorderPainted(false);
		
		btnCommit.setBackground(Color.white);
		btnCommit.setBorderPainted(false);
		
		
		btnCheckout.setBackground(Color.white);
		btnCheckout.setBorderPainted(false);
		
		btnBranch.setBackground(Color.white);
		btnBranch.setBorderPainted(false);
		
		btnMerge.setBackground(Color.white);
		btnMerge.setBorderPainted(false);
		
		btnRebase.setBackground(Color.white);
		btnRebase.setBorderPainted(false);
		
		btnCherry_Pick.setBackground(Color.white);
		btnCherry_Pick.setBorderPainted(false);
		
		btnTag.setBackground(Color.white);
		btnTag.setBorderPainted(false);
		
		btnUser_Setting.setBackground(Color.white);
		btnUser_Setting.setBorderPainted(false);
		
		
		
		JPanel jpview = new JPanel();
		getContentPane().add(jpview, BorderLayout.CENTER);
		jpview.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		jpview.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		spLog = new JScrollPane();
		GridBagConstraints gbc_spLog = new GridBagConstraints();
		gbc_spLog.weightx = 1.0;
		gbc_spLog.weighty = 1.0;
		gbc_spLog.gridheight = 7;
		gbc_spLog.gridwidth = 1;
		gbc_spLog.ipady = 80;
		gbc_spLog.fill = GridBagConstraints.BOTH;
	//	gbc_spLog.insets = new Insets(0, 0, 5, 0);
		gbc_spLog.gridx = 0;
		gbc_spLog.gridy = 0;
		panel.add(spLog, gbc_spLog);
		/*
		taLog = new JTextArea(40,30);
		taLog.setBackground(Color.BLACK);
		taLog.setForeground(Color.GREEN);
		taLog.setEditable(false);
		spLog.setViewportView(taLog);
		*/
		
		tpLog = new JTextPane();
		doc = tpLog.getStyledDocument();
		tpLog.setEditable(false);
		spLog.setViewportView(tpLog);
		
		jtfCommandLine = new JTextField();
		GridBagConstraints gbc_jtfCommandLine = new GridBagConstraints();
		gbc_jtfCommandLine.fill = GridBagConstraints.BOTH;
		gbc_jtfCommandLine.gridx = 0;
		gbc_jtfCommandLine.gridy = 7;
		gbc_jtfCommandLine.gridheight = 1;
		gbc_jtfCommandLine.gridwidth = 1;
		gbc_jtfCommandLine.weightx = 0.1;
		gbc_jtfCommandLine.weighty = 0.1;
		panel.add(jtfCommandLine, gbc_jtfCommandLine);
		jtfCommandLine.setColumns(10);
		
		jspPG = new JScrollPane();
		
		jpPaintGit = new JPanel();
		//Glog glog = new Glog();
		//jpPaintGit.add(glog);
		jspPG.setViewportView(jpPaintGit);
		jpview.add(jspPG);
		
	}
	
	public void init(){
		
		/*
		 * setting screen size and location
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0,0,screenSize.width - 160,screenSize.height - 90);
		int xPos = screenSize.width / 3;
		int yPos = screenSize.height / 3;
		setLocation(xPos - 100, yPos - 50);
		
		MenuBarController menubar = new MenuBarController();
		menubar.init();
		
		setJMenuBar(menubar);
		
		setVisible(true);
		
		
		// Rising UserSetting when client open
		new UserSettingController();
	}
}
