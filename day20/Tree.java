package day20;

import java.util.ArrayList;

public class Tree {

	    Node root; // node gốc của cây

	    public Tree(Node root) {
	        this.root = root;
	    }

	    // Tìm node theo BFS (duyệt theo tầng)
	    public Node findNodeBFS(int targetValue) {
	        if (root == null) {
	            return null;
	        }

	        ArrayList<Node> list= new ArrayList<Node>();
	        list.add(root);
			int index = 0;

	        while (list.size() > index) {
	            Node current = list.get(index);
				index++;

	            if (current.value == targetValue) {
	                return current;
	            }

	            for (int i = 0; i < current.children.size(); i++) {
	                list.add(current.children.get(i));
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

	
	


