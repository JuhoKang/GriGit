package kr.re.ec.grigit.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;

abstract public class AlertDialogFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JButton okButton;
	private JPanel panel;
	private JPanel panel_1;
	protected JLabel lMessage;
	
	/**
	 * Create the dialog.
	 */
	public AlertDialogFrame() {
		setBounds(100, 100, 417, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			lMessage = new JLabel("New label");
			lMessage.setVerticalAlignment(SwingConstants.TOP);
			lMessage.setAlignmentY(Component.TOP_ALIGNMENT);
			contentPanel.add(lMessage);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				GridBagLayout gbl_buttonPane = new GridBagLayout();
				gbl_buttonPane.columnWidths = new int[]{10, 381, 10, 0};
				gbl_buttonPane.rowHeights = new int[]{23, 0};
				gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				buttonPane.setLayout(gbl_buttonPane);
				{
					panel = new JPanel();
					GridBagConstraints gbc_panel = new GridBagConstraints();
					gbc_panel.anchor = GridBagConstraints.WEST;
					gbc_panel.fill = GridBagConstraints.VERTICAL;
					gbc_panel.insets = new Insets(0, 0, 0, 5);
					gbc_panel.weightx = 0.2;
					gbc_panel.gridx = 0;
					gbc_panel.gridy = 0;
					buttonPane.add(panel, gbc_panel);
				}
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.anchor = GridBagConstraints.NORTH;
				gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_okButton.insets = new Insets(0, 0, 0, 5);
				gbc_okButton.weightx = 0.6;
				gbc_okButton.gridx = 1;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
				{
					panel_1 = new JPanel();
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.anchor = GridBagConstraints.WEST;
					gbc_panel_1.fill = GridBagConstraints.VERTICAL;
					gbc_panel_1.weightx = 0.2;
					gbc_panel_1.gridx = 2;
					gbc_panel_1.gridy = 0;
					buttonPane.add(panel_1, gbc_panel_1);
				}
			}
		}
	}

}
