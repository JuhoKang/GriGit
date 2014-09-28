package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.UserInfo;
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

	private Logger logger;
	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	private boolean isOk;

	public UserSettingController() {
		logger = LoggerFactory.getLogger(UserSettingController.class);
		this.setModal(true);
		txtUserName.setText(UserInfo.getInstance().getAuthor());
		txtUserEmail.setText(UserInfo.getInstance().getEmail());
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		logger.info("Check actionperforme");
		// TODO Auto-generated method stub
		if (e.getSource() == btnOk) {
			logger.info("Check ok button");
			isOk = true;
			bgnOkActionPerformed(e);

		} else if (e.getSource() == btnCancel) {

			
			logger.info("Check cancel button");
			isOk = false;
			btnCancelActionPerformed(e);
			// dialog.setVisible(false);
		}
	}

	private void btnCancelActionPerformed(ActionEvent e) {
		dispose();
	}

	private void bgnOkActionPerformed(ActionEvent e) {

		UserInfo.getInstance().setAuthor(txtUserName.getText());
		UserInfo.getInstance().setEmail(txtUserEmail.getText());
		
		dispose();
	}
}