package kr.re.ec.grigit.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.text.BadLocationException;

import kr.re.ec.grigit.ui.controller.MainController;

public class SwingOutputStream extends OutputStream{
	
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void write(byte[] b, int off, int len) throws IOException{
		try {
			MainController.getInstance().getDoc().insertString(
					MainController.getInstance().getDoc().getLength(), 
					new String(b,"UTF-8"), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
