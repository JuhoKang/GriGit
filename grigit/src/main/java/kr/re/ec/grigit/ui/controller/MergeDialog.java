package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

import kr.re.ec.grigit.ui.MergeDialogFrame;

public class MergeDialog extends MergeDialogFrame implements ActionListener{

	private boolean inOrder = false;
	
	public MergeDialog(String first, String second) {
		this.setModal(true);
		lblMessage.setText("Choose the way you are going to merge");
		lblInOrder.setText("merge \"  "+first+"\"into\"  "+second);
		lblNotInOrder.setText("merge \"  "+second+"\"into\"  "+first);
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
		if(e.getSource() == rdbtnInOrder){
			
		}else if (e.getSource() == rdbtnNotInOrder){
			
		}
		if(e.getSource() == okButton){
			if(rdbtnInOrder.isEnabled()){
				inOrder = true;
				this.dispose();
			} else {
				inOrder = false;
				this.dispose();
			}
		}if(e.getSource() == cancelButton){
			this.dispose();
		}
		
	}
	
	
}
