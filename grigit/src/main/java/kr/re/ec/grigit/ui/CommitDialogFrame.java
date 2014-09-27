package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommitDialogFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JLabel lblCommitMessage;
	protected JTextArea taCommitMessage;
	protected JPanel pCheckFile;
	protected JLabel lblCheckFileMessage;
	protected JButton okButton;
	protected JButton cancelButton;


	/**
	 * Create the dialog.
	 */
	public CommitDialogFrame() {
		setBounds(100, 100, 450, 403);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					lblCheckFileMessage = new JLabel("New label");
					panel_1.add(lblCheckFileMessage);
				}
			}
			{
				pCheckFile = new JPanel();
				panel.add(pCheckFile, BorderLayout.CENTER);
				pCheckFile.setLayout(new GridLayout(0, 2, 0, 0));
			}
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				lblCommitMessage = new JLabel();
				lblCommitMessage.setBorder(contentPanel.getBorder());
				panel.add(lblCommitMessage);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				taCommitMessage = new JTextArea();
				taCommitMessage.setColumns(8);
				panel.add(taCommitMessage);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
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
