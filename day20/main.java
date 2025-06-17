package day20;

public class main {
	 public static void main(String[] args) {
	        // Tạo cây:
	        //        0
	        //      /   \
	        //    10     11
	        //   /  \
	        // 20   22

	        Node root = new Node(0);
	        Node node10 = new Node(10);
	        Node node11 = new Node(11);
	        Node node20 = new Node(20);
	        Node node22 = new Node(22);

	        root.children.add(node10);
	        root.children.add(node11);
	        node10.children.add(node20);
	        node10.children.add(node22);

	        Tree tree = new Tree(root);

	        // In cây
	        printNode(root);
	        printNode(node10);
	        printNode(node11);

	        // Tìm kiếm các giá trị
	        int[] targets = {0, 10, 20, 22, 11, 21};
	        for (int target : targets) {
	            Node foundBFS = tree.findNodeBFS(target);
	            Node foundDFS = tree.findNodeDFS(root, target);

	            System.out.println("\nTìm giá trị: " + target);
	            System.out.println("→ BFS: " + (foundBFS != null ? foundBFS.value : "Không tìm thấy"));
	            System.out.println("→ DFS: " + (foundDFS != null ? foundDFS.value : "Không tìm thấy"));
	        }
	    }

	    // Hàm in node và các con của nó
	    public static void printNode(Node node) {
	        System.out.print("Node " + node.value + " → Con: ");
	        for (Node child : node.children) {
	            System.out.print(child.value + " ");
	        }
	        System.out.println();
	    }
	}

