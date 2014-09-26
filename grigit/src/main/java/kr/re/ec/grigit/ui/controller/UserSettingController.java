package kr.re.ec.grigit.ui.controller;



import java.awt.Dialog;
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
public class UserSettingController extends UserSettingDialog implements ActionListener{
@SuppressWarnings("serial") 
	Logger logger;
	
	public UserSettingController() {
		logger = LoggerFactory.getLogger(UserSettingController.class);
		// TODO Auto-generated constructor stub
		init();	
	}
	public void init(){
		super.init();
		
		btnCancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnOk) {
			
			}else if(e.getSource() == btnCancel){
				Dialog.class;
				}		
	}
}