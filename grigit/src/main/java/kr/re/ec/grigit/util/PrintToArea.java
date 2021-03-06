package kr.re.ec.grigit.util;

import java.io.IOException;
import java.io.Writer;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.swing.JTextArea;
import javax.swing.text.Document;
import javax.swing.text.Style;

import kr.re.ec.grigit.ui.controller.MainController;

import org.eclipse.jgit.util.SystemReader;

public class PrintToArea extends Writer{
	
	private final Writer out;
	
	JTextArea jta;
	Document doc;
	
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
		
		System.out.println("I am "+MainController.getInstance().getDoc().getClass());
		LF = AccessController.doPrivileged(new PrivilegedAction<String>() {
			public String run() {
				return SystemReader.getInstance().getProperty("line.separator"); //$NON-NLS-1$
			}
		});
	}
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		System.out.println("write called");
		out.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		System.out.println("flush called");
		out.flush();
	}

	@Override
	public void close() throws IOException {
		System.out.println("close called");
		out.close();
	}
	

	/**
	 * Print a string and terminate with a line feed.
	 *
	 * @param s
	 * @throws IOException
	 */
	public void println(String s) throws IOException {
		
		WriteToPane.getInstance().write(s, null);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), s, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(s + LF);
	}
	public void println(String s,Style style) throws IOException {
		
		WriteToPane.getInstance().write(s, style);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), s, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(s + LF);
	}

	/**
	 * Print a platform dependent new line
	 *
	 * @throws IOException
	 */
	public void println() throws IOException {
		WriteToPane.getInstance().write(LF, null);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), LF, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(LF);
	}

	/**
	 * Print a char
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(char value) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), null);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}
	public void print(char value,Style style) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), style);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}

	/**
	 * Print an int as string
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(int value) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), null);
		/*try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}
	public void print(int value,Style style) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), style);
		/*try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}

	/**
	 * Print a long as string
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(long value) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), null);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}
	public void print(long value,Style style) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), style);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}
	/**
	 * Print a short as string
	 *
	 * @param value
	 * @throws IOException
	 */
	public void print(short value) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), null);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.valueOf(value));
	}
	public void print(short value,Style style) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(value), style);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(value), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		
		WriteToPane.getInstance().write(String.format(fmt, args),null);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.format(fmt, args), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.format(fmt, args));
	}
	public void format(Style style, String fmt, Object... args) throws IOException {
		
		WriteToPane.getInstance().write(String.format(fmt, args),style);
		/*
		try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.format(fmt, args), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		print(String.format(fmt, args));
	}

	/**
	 * Print an object's toString representations
	 *
	 * @param any
	 * @throws IOException
	 */
	public void print(Object any) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(any),null);
		/*try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(any), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		out.write(String.valueOf(any));
	}
	public void print(Object any,Style style) throws IOException {
		WriteToPane.getInstance().write(String.valueOf(any),style);
		/*try {
			doc.insertString(MainController.getInstance().getDoc().getLength(), String.valueOf(any), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		out.write(String.valueOf(any));
	}

}
