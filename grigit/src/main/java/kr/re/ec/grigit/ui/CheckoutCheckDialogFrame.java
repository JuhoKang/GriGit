package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * This is a Dialog checking if you will really checkout
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 */
public class CheckoutCheckDialogFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JButton okButton;
	protected JButton cancelButton;
	protected JLabel DeleteMessage;

	/**
	 * Create the dialog.
	 */
	public CheckoutCheckDialogFrame() {
		setBounds(100, 500, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 10, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			DeleteMessage = new JLabel("");
			DeleteMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			contentPanel.add(DeleteMessage);
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
	
	public void init(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
