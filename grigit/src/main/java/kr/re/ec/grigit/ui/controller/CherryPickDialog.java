package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.ui.CherryPickFrame;

@SuppressWarnings("serial")
public class CherryPickDialog extends CherryPickFrame implements ActionListener {

	private boolean isOk = false;

	public CherryPickDialog() {
		this.setModal(true);
		try {
			lblCherryPickMessage
					.setText("CherryPick selected commits to current HEAD"
							+ CurrentRepository.getInstance().getRepository()
									.getRef("HEAD").getObjectId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.pack();
		this.setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {
			isOk = true;
			this.dispose();
		} else if (e.getSource() == cancelButton) {
			isOk = false;
			this.dispose();
		}
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
