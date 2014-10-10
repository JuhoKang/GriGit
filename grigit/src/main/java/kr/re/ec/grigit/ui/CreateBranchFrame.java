package kr.re.ec.grigit.ui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;


/**
 * This is a Dialog to get Tag name
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 */

@SuppressWarnings("serial")
public class CreateBranchFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JButton okButton;
	protected JButton cancelButton;
	protected JLabel lblMessage;
	protected JLabel lblBranchName;
	protected JTextField jtfBranchNameInput;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public CreateBranchFrame() {
		setBounds(100, 100, 450, 262);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new MigLayout("", "[434px]", "[79px]"));
				{
					lblMessage = new JLabel("New label");
					panel_1.add(lblMessage, "cell 0 0,grow");
				}
			}
			panel.add(contentPanel);
			contentPanel.setBorder(new EmptyBorder(10, 10, 5, 5));
			contentPanel.setLayout(new MigLayout("", "[405px]", "[21px][25px]"));
			{
				lblBranchName = new JLabel("branch name");
				lblBranchName.setFont(UIManager.getFont("Label.font"));
				contentPanel.add(lblBranchName, "cell 0 0,alignx left,aligny top");
			}
			{
				jtfBranchNameInput = new JTextField();
				jtfBranchNameInput.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
				contentPanel.add(jtfBranchNameInput, "cell 0 1,grow");
				jtfBranchNameInput.setColumns(10);
			}
		}
	}

}
