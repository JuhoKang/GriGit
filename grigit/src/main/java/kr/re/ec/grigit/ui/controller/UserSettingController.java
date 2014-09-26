package kr.re.ec.grigit.ui.controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;

import kr.re.ec.grigit.ui.MenuBarFrame;
import kr.re.ec.grigit.ui.UserSettingDialog;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Make UserSettingController
 * @version 1.0.0
 * @author Parker
 *
 */
public class UserSettingController extends UserSettingDialog {
@SuppressWarnings("serial") 
	Logger logger;
	
	public UserSettingController() {
		logger = LoggerFactory.getLogger(UserSettingController.class);
		// TODO Auto-generated constructor stub
		try {
			UserSettingDialog dialog = new UserSettingDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}