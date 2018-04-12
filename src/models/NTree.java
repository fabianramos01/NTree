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
		}
		return null;
	}

	private Node search(Node actual, String info) {
		if (actual.getInfo().equalsIgnoreCase(info)) {
			return actual;
		} else if (!actual.getChilds().isEmpty()) {
			for (Node node : actual.getChilds()) {
				Node seacrh = search(node, info);
				if (seacrh != null) {
					return seacrh;
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
		System.out.println(line + actual.toString());
		if (!actual.getChilds().isEmpty()) {
			for (Node node : actual.getChilds()) {
				print(node, line + "-");
			}
		}
	}

	public Node getRoot() {
		return root;
	}
}