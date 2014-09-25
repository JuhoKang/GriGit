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
 * This is a Dialog to get Tag name
 * @version 1.0.0
 * @author Hyeonseok Ju
 *
 */

public class TagInputDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TagNameInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TagInputDialog dialog = new TagInputDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TagInputDialog() {
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[405px]", "[21px][25px]"));
		{
			JLabel TagNameLabel = new JLabel("태그이름");
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
