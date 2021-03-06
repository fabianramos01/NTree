package models;

import java.io.File;

import controller.ConstantList;

public class ManagerFiles {

	private NTree<String> nTree;

	public ManagerFiles() {
		nTree = new NTree<String>();
	}

	public void loadTree(File file, int num) {
		nTree.addNode(null, new NodeFather<String>(file.getName()));
		loadFiles(file, num);
	}

	private void loadFiles(File actual, int num) {
		File[] files = actual.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (!files[i].isDirectory()) {
					extensionExist(files[i], num);
				} else {
					loadFiles(files[i], num);
				}
			}
		}
	}

	private void extensionExist(File file, int num) {
		String name = file.getName();
		if (name.lastIndexOf(".") == -1) {
			name += ConstantList.OTHER;
		}
		int i = name.lastIndexOf(".");
		Node<String> node = nTree.search(name.substring(i+1));
		while (node == null) {
			createDirectory(name.substring(i + 1), num);
			node = nTree.search(name.substring(i+1));
		}
		if (!node.getChilds().isEmpty()) {
			if (file.length() < num) {
				nTree.addNode(node.getChilds().get(0), new NodeFather<String>(name.substring(0, i)));
			} else {
				nTree.addNode(node.getChilds().get(1), new NodeFather<String>(name.substring(0, i)));
			}
		}
		
	}

	private void createDirectory(String folderName, int num) {
		Node<String> extension = new NodeFather<String>(folderName);
		nTree.addNode(extension, new NodeFather<String>(ConstantList.FOLDER_SMALL + num));
		nTree.addNode(extension, new NodeFather<String>(ConstantList.FOLDER_HIGH + num));
		nTree.addNode(nTree.getRoot(), extension);
	}

	public Node<String> getRoot() {
		return nTree.getRoot();
	}
}