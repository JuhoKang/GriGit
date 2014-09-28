package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.re.ec.grigit.graph.handler.GitController;
import kr.re.ec.grigit.ui.AboutDialog;
import kr.re.ec.grigit.ui.HowToFrame;
import kr.re.ec.grigit.ui.MenuBarFrame;
import kr.re.ec.grigit.ui.UserSettingDialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class MenuBarController extends MenuBarFrame implements ActionListener{
	
	Logger logger;
	
	public MenuBarController() {
		logger = LoggerFactory.getLogger(MenuBarController.class);
		// TODO Auto-generated constructor stub
	}
	
	public void init(){	
		mntmOpenRepo.addActionListener(this);		
		mntmAbout.addActionListener(this);
		mntmBranch.addActionListener(this);
		mntmCommit.addActionListener(this);
		mntmMerge.addActionListener(this);
		mntmCherry_Pick.addActionListener(this);
		mntmHowtoUseCommand.addActionListener(this);
		mntmRebase.addActionListener(this);
		mntmTag.addActionListener(this);
		mntmDelete.addActionListener(this);
		mntmUserSetting.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmOpenRepo){
			new OpenRepoSwing(this);
		} else if(e.getSource() == mntmBranch){			
			GitController.getInstance().createBranch();			
		} else if(e.getSource() == mntmCommit){			
			GitController.getInstance().commit();
		} else if(e.getSource() == mntmMerge){
			GitController.getInstance().merge();			
		} else if(e.getSource() == mntmCherry_Pick){
			GitController.getInstance().cherryPick();
		} else if(e.getSource() == mntmHowtoUseCommand){
			new HowToFrame();
		} else if(e.getSource() == mntmDelete){
			GitController.getInstance().delete();
		} else if(e.getSource() == mntmAbout){
			new AboutDialog();
		} else if(e.getSource() == mntmRebase){
			GitController.getInstance().rebase();
		} else if(e.getSource() == mntmTag){
			GitController.getInstance().createTag();
		} else if(e.getSource() == mntmUserSetting){
			new UserSettingDialog();
		}
	}
	
	

}
