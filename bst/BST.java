package bst;

import java.util.ArrayList;

public class BST {
	Node root; 

	//  Build BST
	public void buildBST(int[] values) {
		for (int value : values) {
			if (root == null) {
				root = new Node(value); 
			} else {
				insert(root, value); 
				balance(null, root); 
			}
		}
	}

	 //Insert value into the tree 
	private Node insert(Node node, int value) {
		if (node == null) return new Node(value);

		if (value < node.value) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}
		return node;
	}

	// Check and balance the tree 
	private int[] balance(Node parent, Node node) {
		if (node == null) return new int[]{-1, -1, -1};

		int[] left = balance(node, node.left);
		int[] right = balance(node, node.right);

		int[] result = new int[3];
		result[1] = left[0];   
		result[2] = right[0];  

		
		if (left[0] - right[0] > 1) {
			if (left[1] < left[2]) rotateLeft(node, node.left);
			rotateRight(parent, node);
		}

		
		if (right[0] - left[0] > 1) {
			if (right[2] < right[1]) rotateRight(node, node.right);
			rotateLeft(parent, node);
		}

		result[0] = Math.max(result[1], result[2]) + 1;
		return result;
	}


	private void rotateRight(Node parent, Node node) {
		Node newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;

		if (parent == null) {
			root = newRoot;
		} else if (parent.left == node) {
			parent.left = newRoot;
		} else {
			parent.right = newRoot;
		}
	}


	private void rotateLeft(Node parent, Node node) {
		Node newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;

		if (parent == null) {
			root = newRoot;
		} else if (parent.left == node) {
			parent.left = newRoot;
		} else {
			parent.right = newRoot;
		}
	}

	//Print tree 
	public void printTree() {
		if (root == null) return;

		ArrayList<Node> queue = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.remove(0);
			System.out.print(current.value + " ");

			if (current.left != null) queue.add(current.left);
			if (current.right != null) queue.add(current.right);
		}
		System.out.println();
	}
}
