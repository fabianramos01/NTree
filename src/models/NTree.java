package models;

public class NTree {

	private Node root;
	
	public NTree() {
	}
	
	public void addNode(Node father, Node node) {
		if (father != null) {
			father.addChild(node);
		} else {
			root = node;
		}
	}
	
	public Node search(String info) {
		if (info != null) {
			return search(root, info);
		} else {
			return null;
		}
	}
	
	private Node search(Node actual, String info) {
		if (actual != null) {
			if (actual.getInfo().equalsIgnoreCase(info)) {
				return actual;
			} else {
				for (int i = 0; i < actual.getChilds().size(); i++) {
					Node node = search(actual.getChilds().get(i), info);
					if (node != null) {
						return node;
					}
				}
			}
		}
		return null;
	}
	
	public void print() {
		if (root != null) {
			print(root, "");
		}
	}
	
	private void print(Node actual, String line) {
		if (actual.getChilds() != null) {
			System.out.println();
		} else {
			for (Node node : actual.getChilds()) {
				print(node, line + "-");
			}
		}
	}
	
	public Node getRoot() {
		return root;
	}
}