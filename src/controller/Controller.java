package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import models.ManagerFiles;
import view.PrincipalFrame;

public class Controller implements ActionListener {

	private ManagerFiles managerFiles;
	private PrincipalFrame pFrame;
	
	public Controller() {
		managerFiles = new ManagerFiles();
		pFrame = new PrincipalFrame(this);
		loadRoot();
	}

	public void loadRoot() {
		pFrame.setVisible(false);
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int selected = fileChooser.showOpenDialog(pFrame);
		if (selected == JFileChooser.APPROVE_OPTION) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de referencia (MB)"));
			num *= 1000000;
			managerFiles.loadTree(fileChooser.getSelectedFile(), num);
		}
		pFrame.paintTree(managerFiles.getRoot());
		pFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ActionCommand.valueOf(e.getActionCommand())) {
		case COMMAND_LOAD_TREE:
			loadRoot();
			break;
		}
		
	}
	
	
}