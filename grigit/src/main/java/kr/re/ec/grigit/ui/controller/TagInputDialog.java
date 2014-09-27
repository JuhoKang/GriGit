package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.ui.TagInputDialogFrame;

public class TagInputDialog extends TagInputDialogFrame implements ActionListener{

	
	private boolean isOk = false;
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public TagInputDialog(){
		
		this.setModal(true);
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okButton){
			name = TagNameInput.getText();
			isOk = true;
			this.dispose();
		} else if(e.getSource() == cancelButton) {
			isOk = false;
			this.dispose();
		}
		
	}
	
	
}
