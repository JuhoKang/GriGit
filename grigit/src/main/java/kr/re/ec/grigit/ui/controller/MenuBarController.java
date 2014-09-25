package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import kr.re.ec.grigit.CurrentRepository;
import kr.re.ec.grigit.git.OpenRepository;
import kr.re.ec.grigit.jgraphx.test.ui.GrigitGraph;
import kr.re.ec.grigit.ui.MenuBarFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

@SuppressWarnings("serial")
public class MenuBarController extends MenuBarFrame implements ActionListener{
	
	Logger logger;
	
	public MenuBarController() {
		logger = LoggerFactory.getLogger(MenuBarController.class);
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		
		mntmOpenRepo.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmOpenRepo){
			new OpenRepositorySwing(this);
		}		
	}
	
	

}
