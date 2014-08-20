package kr.re.ec.grigit.util;

import java.io.IOException;
import java.io.Writer;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;

import kr.re.ec.grigit.ui.controller.MainController;

import org.eclipse.jgit.util.SystemReader;

public class PrintToArea extends Writer{
	
	private final Writer out;
	
	JTextArea jta;
	Document doc;
	Style primarystyle;
	
	private final String LF;

	/**
	 * Construct a JGitPrintWriter
	 *
	 * @param out
	 *            the underlying {@link Writer}
	 */
	public PrintToArea(Writer out) {
		this.out = out;
		doc = MainController.getInstance().getDoc();
		//this.jta = MainController.getInstance().getTaLog();
		
		//System.out.println("I am "+MainController.getInstance().getTaLog().getClass());
		System.out.println("I am "+MainController.getInstance().getDoc().getClass());
		LF = AccessController.doPrivileged(new PrivilegedAction<String>() {
			public String run() {
				return SystemReader.getInstance().getProperty("line.separator"); //$NON-NLS-1$
			}
		});
	}
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		out.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void close() throws IOException {
		out.close();
	}
	

	/**
	 * Print a string and terminate with a line feed.
	 *
	 * @param s
	 * @throws IOException
	 */
	public void println(String s) throws IOException {
		//jta.append(s + LF);
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), s, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(s + LF);
	}

	/**
	 * Print a platform dependent new line
	 *
	 * @throws IOException
	 */
	public void println() throws IOException {
		//jta.append(LF);
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), LF, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(LF);
	}

	/**
	 * Print a char
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(char value) throws IOException {
		//jta.append(String.valueOf(value));
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(String.valueOf(value));
	}

	/**
	 * Print an int as string
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(int value) throws IOException {
		//jta.append(String.valueOf(value));
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(String.valueOf(value));
	}

	/**
	 * Print a long as string
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(long value) throws IOException {
		//jta.append(String.valueOf(value));
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(String.valueOf(value));
	}

	/**
	 * Print a short as string
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(short value) throws IOException {
		//jta.append(String.valueOf(value));
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(String.valueOf(value));
	}

	/**
	 * Print a formatted message according to
	 * {@link String#format(String, Object...)}.
	 *
	 * @param fmt
	 * @param args
	 * @throws IOException
	 */
	public void format(String fmt, Object... args) throws IOException {
		//jta.append(String.format(fmt, args));
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.format(fmt, args), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(String.format(fmt, args));
	}

	/**
	 * Print an object's toString representations
	 *
	 * @param any
	 * @throws IOException
	 */
	public void print(Object any) throws IOException {
		//jta.append(String.valueOf(any));
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(any), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(String.valueOf(any));
	}

}
