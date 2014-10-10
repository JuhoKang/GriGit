package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class HowToFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public HowToFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1403, 992);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getImage("Command001.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getImage("Command002.png")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getImage("Command003.png")));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getImage("Command004.png")));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(getImage("Command005.png")));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon(getImage("Command006.png")));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(new ImageIcon(getImage("Command007.png")));
		panel.add(lblNewLabel_6);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public static Image getImage(final String pathAndFileName) {
	    final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    return Toolkit.getDefaultToolkit().getImage(url);
	}
}
