package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.ui.AlertDialogFrame;

public class AlertDialog extends AlertDialogFrame implements ActionListener{
	
	public AlertDialog(String message) {
		lMessage.setText(message);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton){
			this.dispose();
		}
		
	}	
}
