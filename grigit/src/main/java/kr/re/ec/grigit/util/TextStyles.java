package kr.re.ec.grigit.util;

import java.awt.Color;

import javax.swing.text.Style;


import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class that keeps the Styles for TextPane.<br>
 * Holds some Text Styles<br>
 * 
 * @author Kang Juho
 * @version 1.0.0
 * *
 * 
 * Add LOG Style
 * @author Parker
 */


public class TextStyles {

	public final Style ALERT;
	public final Style LOG;
	public final Style COMMAND;
	protected Logger logger;
	protected StyleContext context;
	
	private TextStyles() {
		logger = LoggerFactory.getLogger(TextStyles.class);
		context = new StyleContext();
		
		//Alert
		ALERT = context.addStyle("alert", null);
		LOG = context.addStyle("log", null);
		COMMAND = context.addStyle("command", null);
		configureAlertStyle();
		configureLogStyle();
		configureCommandStyle();
	}
	
	protected void configureAlertStyle(){
		StyleConstants.setForeground(ALERT, Color.red);
		StyleConstants.setBold(ALERT, true);
	}
	protected void configureLogStyle(){
		StyleConstants.setForeground(LOG, Color.blue);
		StyleConstants.setBold(LOG, true);
	}
	protected void configureCommandStyle(){
		StyleConstants.setForeground(COMMAND, Color.magenta);
		StyleConstants.setBold(COMMAND, true);
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
