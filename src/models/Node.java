package models;

import java.util.ArrayList;

public class Node {

	private String info;
	private ArrayList<Node> childs;
	
	public Node(String info) {
		this.info = info;
		childs = new ArrayList<>();
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	protected ArrayList<Node> getChilds() {
		return childs;
	}
	
	protected void addChild(Node node) {
		childs.add(node);
	}
	
	@Override
	public String toString() {
		return info;
	}
}