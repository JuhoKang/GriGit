package kr.re.ec.grigit.ui.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		bufferReader();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		logger.info("Check actionperforme");
		// TODO Auto-generated method stub
		if (e.getSource() == btnOk) {
			logger.info("Check ok button");
			bgnOkActionPerformed(e);

		} else if (e.getSource() == btnCancel) {

			logger.info("Check cancel button");
			btnCancelActionPerformed(e);
			// dialog.setVisible(false);
		}
	}

	private void btnCancelActionPerformed(ActionEvent e) {
		dispose();
	}

	private void bgnOkActionPerformed(ActionEvent e) {
		String UserName = txtUserName.getText();
		String UserEmail = txtUserEmail.getText();

		bufferWriter(UserName, UserEmail);
		dispose();
	}

	private void bufferWriter(String name, String mail) {
		FileWriter file_writer = null;
		BufferedWriter buf_writer = null;

		try {
			file_writer = new FileWriter("resources/UserSetting.txt", false);
			buf_writer = new BufferedWriter(file_writer);
			logger.info(name);
			logger.info(mail);

			buf_writer.write(name);
			buf_writer.newLine();
			buf_writer.write(mail);

			buf_writer.flush();
			file_writer.flush();

			/*
			 * file_writer.write(name); file_writer.write("");
			 * file_writer.write(mail);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file_writer != null)
				try {
					file_writer.close();
				} catch (IOException e) {
				}
			if (buf_writer != null)
				try {
					buf_writer.close();
				} catch (IOException e) {
				}

		}
	}

	private void bufferReader() {
		FileReader file_reader = null;
		BufferedReader buf_reader = null;

		try {
			file_reader = new FileReader("resources/UserSetting.txt");
			buf_reader = new BufferedReader(file_reader);
			txtUserName.setText(buf_reader.readLine());
			txtUserEmail.setText(buf_reader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (buf_reader != null)
				try {
					buf_reader.close();
				} catch (IOException e) {
				}
			if (buf_reader != null)
				try {
					buf_reader.close();
				} catch (IOException e) {
				}

		}
	}
}