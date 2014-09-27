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


/**
 * This is a Dialog to get Tag name
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 */

@SuppressWarnings("serial")
public class TagInputDialogFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField TagNameInput;
	protected JButton okButton;
	protected JButton cancelButton;
	protected JLabel TagNameLabel;


	/**
	 * Create the dialog.
	 */
	public TagInputDialogFrame() {
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[405px]", "[21px][25px]"));
		{
			TagNameLabel = new JLabel("Tag Name");
			TagNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			contentPanel.add(TagNameLabel, "cell 0 0,alignx left,aligny top");
		}
		{
			TagNameInput = new JTextField();
			TagNameInput.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
			contentPanel.add(TagNameInput, "cell 0 1,grow");
			TagNameInput.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("확인");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("취소");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
