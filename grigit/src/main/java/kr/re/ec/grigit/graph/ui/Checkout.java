package kr.re.ec.grigit.graph.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Checkout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout frame = new Checkout();
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
	public Checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckout = new JLabel("정말 Checkout 하시겠습니까?");
		lblCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckout.setFont(new Font("굴림", Font.BOLD, 16));
		lblCheckout.setBounds(58, 12, 253, 50);
		contentPane.add(lblCheckout);
		
		JButton btnCheck = new JButton("확 인");
		btnCheck.setFont(new Font("굴림", Font.BOLD, 16));
		btnCheck.setBounds(146, 74, 105, 27);
		contentPane.add(btnCheck);
		
		JButton btnCancel = new JButton("취 소");
		btnCancel.setFont(new Font("굴림", Font.BOLD, 16));
		btnCancel.setBounds(263, 74, 105, 27);
		contentPane.add(btnCancel);
	}

}
