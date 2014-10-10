package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.ui.DeleteCheckDialogFrame;

@SuppressWarnings("serial")
public class DeleteCheckDialog extends DeleteCheckDialogFrame implements ActionListener{
	
	private boolean isOk = false;
	
	public DeleteCheckDialog(String name){
		this.setModal(true);
		
		lblMessage.setText("Would you delete " + "\""+name+"\"");
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.pack();
		this.setVisible(true);
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton){
			isOk = true;
			this.dispose();
		} else if(e.getSource() == cancelButton){
			isOk = false;
			this.dispose();
		}
		
	}

}
