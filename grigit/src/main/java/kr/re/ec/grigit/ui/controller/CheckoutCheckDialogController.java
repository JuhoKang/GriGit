package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.ui.CheckoutCheckDialogFrame;

@SuppressWarnings("serial")
public class CheckoutCheckDialogController extends CheckoutCheckDialogFrame implements ActionListener{

	private boolean isOk;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CheckoutCheckDialogController(String name) {
		isOk = false;
		this.name = name;
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.setModal(true);
		DeleteMessage.setText("Would you checkout \""+ name +"\"");
		this.pack();
		this.setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okButton){
			isOk = true;
			this.dispose();
		} else if (e.getSource() == cancelButton){
			isOk = false;
			this.dispose();
		}
		
	}

}
