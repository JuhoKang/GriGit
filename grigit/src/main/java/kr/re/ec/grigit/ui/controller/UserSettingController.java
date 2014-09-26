package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.ui.UserSettingDialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Make UserSettingController
 * 
 * @version 1.0.0
 * @author Parker
 *
 */
@SuppressWarnings("serial")
public class UserSettingController extends UserSettingDialog implements
		ActionListener {

	Logger logger;

	public UserSettingController() {
		logger = LoggerFactory.getLogger(UserSettingController.class);
		this.setModal(true);
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		logger.info("Check actionperforme");
		// TODO Auto-generated method stub
		if (e.getSource() == btnOk) {	

		} else if (e.getSource() == btnCancel) {

			logger.info("Check button");
			btnCancelActionPerformed(e);
			// dialog.setVisible(false);
			logger.info("Check set visible");
		}
	}

	private void btnCancelActionPerformed(ActionEvent e) {
		dispose();
	}
}