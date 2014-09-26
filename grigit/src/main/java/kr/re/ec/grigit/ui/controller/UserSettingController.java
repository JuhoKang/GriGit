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
public class UserSettingController extends UserSettingDialog implements	ActionListener {
	@SuppressWarnings("serial")
	Logger logger;

	private UserSettingController() {
		logger = LoggerFactory.getLogger(UserSettingController.class);
		// TODO Auto-generated constructor stub
	}

	public static UserSettingController getInstance() {
		return SingletonHolder.instance;
	}

	// for singleton
	private static class SingletonHolder {
		private static final UserSettingController instance = new UserSettingController();
	}
	public void init() {
		super.init();

		btnCancel.addActionListener(this);
}

	public void actionPerformed(ActionEvent e) {
		logger.info("Check actionperforme");
		String btn = e.getActionCommand();
		// TODO Auto-generated method stub
		if (btn.equals("Cancel")
				//e.getSource() == btnCancel
		) {
			logger.info("Check button");
			dialog.setVisible(false);
			logger.info("Check set visible");
		}
	}
}