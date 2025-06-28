package binaryTree;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createSampleTree();

        if (tree.isBalance()) {
            System.out.println(" Balance Node");
        } else {
            System.out.println(" IMBALANCE node.");
        }

        ArrayList<Node> badNodes = tree.findImbalanceNode();

        System.out.print("Imbalance Node is: ");
        for (Node n : badNodes) {
            System.out.print(n.value + " ");
        }
    }
}
