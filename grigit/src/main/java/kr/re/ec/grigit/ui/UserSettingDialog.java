package kr.re.ec.grigit.ui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;


/**
 * This is a Dialog to get your name and email
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 */

public class UserSettingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField UserEmailInput;
	private JTextField UserNameInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserSettingDialog dialog = new UserSettingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserSettingDialog() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		contentPanel.setLayout(new MigLayout("", "[405px,grow]", "[][21px][25px][17.00][][][]"));
		{
			JLabel UserNameLabel = new JLabel("Name");
			UserNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			contentPanel.add(UserNameLabel, "cell 0 0,alignx left,aligny top");
		}
		{
			UserNameInput = new JTextField();
			UserNameInput.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
			UserNameInput.setColumns(10);
			contentPanel.add(UserNameInput, "cell 0 2,growx");
		}
		{
			JLabel UserEmailLabel = new JLabel("Email");
			UserEmailLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			contentPanel.add(UserEmailLabel, "cell 0 4");
		}
		{
			UserEmailInput = new JTextField();
			UserEmailInput.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
			contentPanel.add(UserEmailInput, "cell 0 6,grow");
			UserEmailInput.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("확인");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
