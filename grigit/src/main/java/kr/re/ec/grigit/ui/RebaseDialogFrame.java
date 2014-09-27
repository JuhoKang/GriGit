package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RebaseDialogFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JRadioButton rdbtnInOrder;
	protected JRadioButton rdbtnNotInOrder;
	protected JLabel lblInOrderMessage;
	protected JLabel lblNotInOrderMessage;
	protected JLabel lblMessage;
	protected JButton okButton;
	protected JButton cancelButton;
	protected JLabel lblInOrderName;
	protected JLabel lblNotInOrderName;

	/**
	 * Create the dialog.
	 */
	public RebaseDialogFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				{
					rdbtnInOrder = new JRadioButton("");
					panel_1.add(rdbtnInOrder);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					lblInOrderMessage = new JLabel("New label");
					panel_1.add(lblInOrderMessage);
				}
				{
					lblInOrderName = new JLabel("New label");
					panel_1.add(lblInOrderName, BorderLayout.NORTH);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				{
					rdbtnNotInOrder = new JRadioButton("");
					panel_1.add(rdbtnNotInOrder);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					lblNotInOrderMessage = new JLabel("New label");
					panel_1.add(lblNotInOrderMessage);
				}
				{
					lblNotInOrderName = new JLabel("New label");
					panel_1.add(lblNotInOrderName, BorderLayout.NORTH);
				}
			}
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
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				lblMessage = new JLabel("New label");
				panel.add(lblMessage);
			}
		}
	}

}
