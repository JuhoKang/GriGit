package kr.re.ec.grigit.ui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;


/**
 * This is a Dialog to get your name and email
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 * Remove Main. Make init method.
 * @author Parker
 */

public class UserSettingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtUserEmail;
	protected JTextField txtUserName;

	protected JButton btnCancel;
	protected JButton btnOk;
	protected UserSettingDialog dialog;
	/**
	 * Launch the application.
	 */

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
			UserNameLabel.setFont(UIManager.getFont("Label.font"));
			contentPanel.add(UserNameLabel, "cell 0 0,alignx left,aligny top");
		}
		{
			txtUserName = new JTextField();
			txtUserName.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
			txtUserName.setColumns(10);
			contentPanel.add(txtUserName, "cell 0 2,growx");
		}
		{
			JLabel UserEmailLabel = new JLabel("Email");
			UserEmailLabel.setFont(UIManager.getFont("Label.font"));
			contentPanel.add(UserEmailLabel, "cell 0 4");
		}
		{
			txtUserEmail = new JTextField();
			txtUserEmail.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
			contentPanel.add(txtUserEmail, "cell 0 6,grow");
			txtUserEmail.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				//getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				
			}
		}
		this.setAlwaysOnTop(true);
	}

}
