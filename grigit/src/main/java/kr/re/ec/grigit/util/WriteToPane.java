package kr.re.ec.grigit.util;

import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import kr.re.ec.grigit.ui.controller.MainController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteToPane {

	private StyledDocument doc;
	Logger logger;
	
	// for singleton
	private WriteToPane() {
		logger = LoggerFactory.getLogger(MainController.class);
		doc = MainController.getInstance().getDoc();
	}

	// for singleton
	/**
	 * Method getInstance.
	 * 
	 * @return CurrentRepository
	 */
	public static WriteToPane getInstance() {
		return SingletonHolder.instance;
	}

	// for singleton
	private static class SingletonHolder {
		private static final WriteToPane instance = new WriteToPane();
	}

	public void write(String s, Style style) {
		update();
		try {
			doc.insertString(doc.getLength(), s, style);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			logger.info("Doc Bad Location Exception");
			e.printStackTrace();
		}
	}

	private void update() {
		doc = MainController.getInstance().getDoc();
	}

}
