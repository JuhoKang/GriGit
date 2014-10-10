package kr.re.ec.grigit.ui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 * This is a Dialog checking if you will really gonna Delete
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 */

@SuppressWarnings("serial")
public class DeleteCheckDialogFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JLabel lblMessage;
	protected JButton okButton;
	protected JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public DeleteCheckDialogFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			lblMessage = new JLabel("New label");
			contentPanel.add(lblMessage);
		}
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
	}

}
