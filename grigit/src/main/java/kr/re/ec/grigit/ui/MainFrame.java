package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;

import kr.re.ec.grigit.ui.controller.MenuBarController;

import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.text.StyledDocument;

/**
 * MainFrame class for the Main Window of grigit
 * 
 * @version 1.0.0
 * @author Juho Kang
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
	
	protected JButton btnNewButton;
	protected JButton btnNewButton_1;
	protected JButton btnNewButton_2;
	protected JButton btnNewButton_3;
	protected JButton btnNewButton_4;
	protected JButton btnNewButton_5;
	protected JButton btnNewButton_6;
	
	private JPanel panel;
	protected JTextField jtfCommandLine;
	private JScrollPane spLog;
	//private JTextArea taLog;
	protected JTextPane tpLog;
	protected StyledDocument doc;
	
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel jpToolBar = new JPanel();
		getContentPane().add(jpToolBar, BorderLayout.NORTH);
		GridBagLayout gbl_jpToolBar = new GridBagLayout();
		gbl_jpToolBar.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jpToolBar.rowHeights = new int[]{0, 0};
		gbl_jpToolBar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpToolBar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jpToolBar.setLayout(gbl_jpToolBar);
		
		btnNewButton = new JButton("Clone");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		jpToolBar.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Commit");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		jpToolBar.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_2 = new JButton("Checkout");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		jpToolBar.add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_3 = new JButton("Branch");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 0;
		jpToolBar.add(btnNewButton_3, gbc_btnNewButton_3);
		
		btnNewButton_4 = new JButton("Merge");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		jpToolBar.add(btnNewButton_4, gbc_btnNewButton_4);
		
		btnNewButton_5 = new JButton("Rebase");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton_5.gridx = 5;
		gbc_btnNewButton_5.gridy = 0;
		jpToolBar.add(btnNewButton_5, gbc_btnNewButton_5);
		
		btnNewButton_6 = new JButton("Cherry-Pick");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 8);
		gbc_btnNewButton_6.gridx = 6;
		gbc_btnNewButton_6.gridy = 0;
		jpToolBar.add(btnNewButton_6, gbc_btnNewButton_6);
		
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
		
		JPanel jpPaintGit = new JPanel();
		jpview.add(jpPaintGit);
		
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
		
	}
}
