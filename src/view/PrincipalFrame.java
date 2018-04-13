package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ConstantList;
import models.Node;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTree jTree;
	private DefaultMutableTreeNode model;
	
	public PrincipalFrame(ActionListener listener) {
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setJMenuBar(new MenuBar(listener));
		model = new DefaultMutableTreeNode();
		jTree = new JTree(model);
		add(new JScrollPane(jTree), BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void paintTree(Node root) {
		DefaultMutableTreeNode uiRoot = new DefaultMutableTreeNode(root);
		model.add(uiRoot);
		for (Node node : root.getChilds()) {
			createNode(uiRoot, node);
		}
	}
	
	private void createNode(DefaultMutableTreeNode actual, Node node) {
		if (node != null) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node);
			actual.add(newNode);
			for (Node child : node.getChilds()) {
				createNode(newNode, child);
			}
		}
	}
}