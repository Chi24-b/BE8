package binaryTree;

import java.util.ArrayList;

public class Tree {

	Node root;
	
	public boolean isBalance() {
		return check(root, new ArrayList<>()) != -1;
		
	}
	
	public ArrayList<Node> findImbalanceNode() {
		ArrayList<Node> result = new ArrayList<>();
        check(root, result);
        return result;
    }
	
	private int check(Node node, ArrayList<Node> list) {
        if (node == null) return 0;

        int left = check(node.left, list);
        int right = check(node.right, list);

        if (Math.abs(left - right) > 1) {
            list.add(node);
        }

        return Math.max(left, right) + 1;
    }
	
	public void createSampleTree() {
        root = new Node();
        root.value = 1;

        root.left = new Node();
        root.left.value = 2;

        root.right = new Node();
        root.right.value = 3;

        root.left.left = new Node();
        root.left.left.value = 4;

        root.left.left.left = new Node();
        root.left.left.left.value = 5;
	}
}
  