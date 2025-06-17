package day20;

import java.util.ArrayList;

public class Tree {

	 public Node root; // node gốc của cây

	    public Tree(Node root) {
	        this.root = root;
	    }

	    // Tìm node theo BFS (duyệt theo tầng)
	    public Node findNodeBFS(int targetValue) {
	        if (root == null) {
	            return null;
	        }

	        ArrayList<Node> queue = new ArrayList<Node>();
	        queue.add(root);

	        while (queue.size() > 0) {
	            Node current = queue.remove(0);

	            if (current.value == targetValue) {
	                return current;
	            }

	            for (Node child : current.children) {
	                queue.add(child);
	            }
	        }

	        return null;
	    }

	    // Tìm node theo DFS (đệ quy duyệt theo nhánh)
	    public Node findNodeDFS(Node current, int targetValue) {
	        if (current == null) {
	            return null;
	        }

	        if (current.value == targetValue) {
	            return current;
	        }

	        for (Node child : current.children) {
	            Node result = findNodeDFS(child, targetValue);
	            if (result != null) {
	                return result;
	            }
	        }

	        return null;
	    }
	}

	
	


