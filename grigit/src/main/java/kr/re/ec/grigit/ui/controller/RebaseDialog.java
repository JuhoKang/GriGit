package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import kr.re.ec.grigit.ui.RebaseDialogFrame;

@SuppressWarnings("serial")
public class RebaseDialog extends RebaseDialogFrame implements ActionListener{
	
	private boolean inOrder = false;
	private boolean isCancel = true;

	public boolean isCancel() {
		return isCancel;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public RebaseDialog(String firstName, String firstMessage,
			String secondName, String secondMessage) {
		this.setModal(true);
		lblMessage.setText("Choose the way you are going to merge");
		lblInOrderName
				.setText("<html><font color=blue><b>CHECKOUT</b></font> <br>\"" + firstName
						+ "\"<br><br><font color=red><b>REBASE</b></font><br>\"  " + secondName
						+ "<hr></html>");
		lblInOrderMessage.setText("<html><font color=red><b>REBASE</b></font><br>" + secondMessage
				+ "<br><br><font color=red><b>INTO</b></font><br><br>" + firstMessage + "</html>");
		lblNotInOrderName.setText("<html><font color=blue><b>CHECKOUT</b></font> <br>\"  " + secondName
				+ "\"<br><br><font color=red><b>REBASE</b></font><br>\"  " + firstName + "<hr></html>");
		lblNotInOrderMessage.setText("<html><font color=red><b>REBASE</b></font><br> " + firstMessage
				+ "<br><br><font color=red><b>INTO</b></font><br><br>" + secondMessage + "</html>");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnInOrder);
		bg.add(rdbtnNotInOrder);

		rdbtnInOrder.addActionListener(this);
		rdbtnNotInOrder.addActionListener(this);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);

		this.pack();
		this.setVisible(true);
	}

	public boolean isInOrder() {
		return inOrder;
	}

	public void setInOrder(boolean inOrder) {
		this.inOrder = inOrder;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == rdbtnInOrder) {

		} else if (e.getSource() == rdbtnNotInOrder) {

		}
		if (e.getSource() == okButton) {
			if (rdbtnInOrder.isEnabled()) {
				inOrder = true;				
			} else {
				inOrder = false;
			}
			this.isCancel = false;
			this.dispose();
		}
		if (e.getSource() == cancelButton) {
			this.isCancel = true;
			this.dispose();
		}

	}


}
