package kr.re.ec.grigit.util;

import java.awt.Color;

import javax.swing.text.Style;


import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TextStyles {

	public final Style ALERT;
	protected Logger logger;
	protected StyleContext context;
	
	private TextStyles() {
		logger = LoggerFactory.getLogger(TextStyles.class);
		context = new StyleContext();
		ALERT = context.addStyle("alert", null);
		StyleConstants.setForeground(ALERT, Color.red);
		StyleConstants.setBold(ALERT, true);
	}

	// for singleton
	/**
	 * Method getInstance.
	 * 
	 * @return CurrentRepository
	 */
	public static TextStyles getInstance() {
		return SingletonHolder.instance;
	}

	// for singleton
	private static class SingletonHolder {
		private static final TextStyles instance = new TextStyles();
	}
	
}
