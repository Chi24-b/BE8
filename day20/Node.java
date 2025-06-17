package day20;

import java.util.ArrayList;

public class Node {
	int value;
	ArrayList<Node> children;
	
	public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
	
	 public Node(int value, ArrayList<Node> children) {
	        this.value = value;
	        this.children = children;
	    }
	}


