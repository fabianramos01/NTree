package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controller.ConstantList;
import models.Node;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTree jTree;
	private DefaultTreeModel model;
	private DefaultMutableTreeNode root;
	
	public PrincipalFrame(ActionListener listener) {
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setJMenuBar(new MenuBar(listener));
		root = new DefaultMutableTreeNode();
		model = new DefaultTreeModel(root);
		jTree = new JTree(model);
		add(new JScrollPane(jTree), BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void paintTree(Node rootNode) {
		root = new DefaultMutableTreeNode(rootNode);
		model.setRoot(root);
		for (Node node : rootNode.getChilds()) {
			createNode(root, node);
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