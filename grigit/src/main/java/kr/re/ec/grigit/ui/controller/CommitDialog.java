package kr.re.ec.grigit.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import kr.re.ec.grigit.ui.CommitDialogFrame;
import kr.re.ec.grigit.util.TextStyles;
import kr.re.ec.grigit.util.WriteToPane;

@SuppressWarnings("serial")
public class CommitDialog extends CommitDialogFrame implements ActionListener {

	private boolean isCancel = true;
	ArrayList<JCheckBox> jcbList;
	ArrayList<String> checkedFileList;
	String commitMessage;

	public CommitDialog(Set<String> addedFiles, Set<String> changedFiles,
			Set<String> missingFiles, Set<String> modifiedFiles,
			Set<String> removedFiles, Set<String> untrackedFiles) {
		jcbList = new ArrayList<JCheckBox>();
		this.setModal(true);
		lblCheckFileMessage.setText("check the files you want to commit");
		for (String file : addedFiles) {
			JCheckBox jcb = new JCheckBox(file);
			jcbList.add(jcb);
			pCheckFile.add(jcb);
			pCheckFile.add(new JLabel("Added"));
		}
		for (String file : changedFiles) {
			JCheckBox jcb = new JCheckBox(file);
			jcbList.add(jcb);
			pCheckFile.add(jcb);
			pCheckFile.add(new JLabel("Changed"));
		}
		for (String file : missingFiles) {
			JCheckBox jcb = new JCheckBox(file);
			jcbList.add(jcb);
			pCheckFile.add(jcb);
			pCheckFile.add(new JLabel("Missing"));
		}
		for (String file : modifiedFiles) {
			JCheckBox jcb = new JCheckBox(file);
			jcbList.add(jcb);
			pCheckFile.add(jcb);
			pCheckFile.add(new JLabel("Modified"));
		}
		for (String file : removedFiles) {
			JCheckBox jcb = new JCheckBox(file);
			jcbList.add(jcb);
			pCheckFile.add(jcb);
			pCheckFile.add(new JLabel("Removed"));
		}
		for (String file : untrackedFiles) {
			JCheckBox jcb = new JCheckBox(file);
			jcbList.add(jcb);
			pCheckFile.add(jcb);
			pCheckFile.add(new JLabel("Untracked"));
		}

		lblCommitMessage.setText("Write your commit message here");

		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {

			checkedFileList = new ArrayList<String>();
			
			for(JCheckBox checkBox : jcbList){
				if(checkBox.isSelected()){
					checkedFileList.add(checkBox.getText());
				} else{
					
				}
				
			}
			
			if(taCommitMessage.getText().isEmpty()){
				isCancel = true;
				WriteToPane.getInstance().write("You must write commit message",TextStyles.getInstance().ALERT);
			}
			commitMessage = taCommitMessage.getText();
			isCancel = false;
			this.dispose();

		} else if (e.getSource() == cancelButton) {
			isCancel = true;
			this.dispose();

		}

	}

	public String getCommitMessage() {
		return commitMessage;
	}

	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}

	public boolean isCancel() {
		return isCancel;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public ArrayList<String> getCheckedFileList() {
		return checkedFileList;
	}

	public void setCheckedFileList(ArrayList<String> checkedFileList) {
		this.checkedFileList = checkedFileList;
	}

}
