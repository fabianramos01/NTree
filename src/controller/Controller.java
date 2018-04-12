package controller;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import models.ManagerFiles;
import view.PrincipalFrame;

public class Controller {

	private ManagerFiles managerFiles;
	private PrincipalFrame pFrame;
	
	public Controller() {
		managerFiles = new ManagerFiles();
		pFrame = new PrincipalFrame();
		init();
	}

	private void init() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int selected = fileChooser.showOpenDialog(pFrame);
		if (selected == JFileChooser.APPROVE_OPTION) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de referencia"));
			num *= 1000000;
			managerFiles.loadTree(fileChooser.getSelectedFile(), num);
		}
	}
	
	
}