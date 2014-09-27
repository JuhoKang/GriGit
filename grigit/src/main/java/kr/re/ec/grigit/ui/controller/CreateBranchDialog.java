package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.ui.CreateBranchFrame;

@SuppressWarnings("serial")
public class CreateBranchDialog extends CreateBranchFrame implements ActionListener{
	
	private String branchName;
	private boolean isCancel = true;
	
	public boolean isCancel() {
		return isCancel;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public CreateBranchDialog(String name) {
		
		this.setModal(true);
		
		lblMessage.setText("<html>Create a branch to <br>\""+name+"\"");
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton){
			branchName = jtfBranchNameInput.getText();
			isCancel = false;
			this.dispose();
		}else if(e.getSource() == cancelButton){
			isCancel = true;
			this.dispose();
		}
		
	}

}
