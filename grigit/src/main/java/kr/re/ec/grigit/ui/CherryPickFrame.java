package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class CherryPickFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CherryPickFrame frame = new CherryPickFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CherryPickFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCheck = new JButton("확 인");
		btnCheck.setFont(new Font("굴림", Font.BOLD, 15));
		btnCheck.setBounds(503, 214, 105, 27);
		contentPane.add(btnCheck);
		
		JLabel lblSelectedCommit = new JLabel("");
		lblSelectedCommit.setBounds(59, 51, 351, 149);
		contentPane.add(lblSelectedCommit);
		
		JButton btnCancel = new JButton("취 소");
		btnCancel.setFont(new Font("굴림", Font.BOLD, 15));
		btnCancel.setBounds(622, 214, 105, 27);
		contentPane.add(btnCancel);
		
		JLabel lblTarget = new JLabel("");
		lblTarget.setBounds(424, 51, 348, 149);
		lblTarget.setBackground(Color.white);
		contentPane.add(lblTarget);
		
		JLabel lblnmSelectedCommit = new JLabel("선택된 커밋들");
		lblnmSelectedCommit.setFont(new Font("굴림", Font.BOLD, 17));
		lblnmSelectedCommit.setHorizontalAlignment(SwingConstants.CENTER);
		lblnmSelectedCommit.setBounds(59, 12, 147, 27);
		contentPane.add(lblnmSelectedCommit);
		
		JLabel lblnmTarget = new JLabel("대상");
		lblnmTarget.setBackground(UIManager.getColor("Button.highlight"));
		lblnmTarget.setHorizontalAlignment(SwingConstants.CENTER);
		lblnmTarget.setFont(new Font("굴림", Font.BOLD, 17));
		lblnmTarget.setBounds(424, 12, 147, 27);
		contentPane.add(lblnmTarget);
	}
}