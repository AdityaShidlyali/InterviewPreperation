import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    BinaryTree(int data) {
        this.root = new Node(data);
    }

    /*
        Time Complexity: O(n)
        Auxiliary space: O(height of tree (longest path from root to leaf node))
    */
    private void printPreorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // print the data of the node
        System.out.print(node.data + " ");

        // first recur on the left of the binary tree
        printPreorderTraversal(node.left);

        // first recur on the right of the binary tree
        printPreorderTraversal(node.right);
    }

    /*
        Time Complexity: O(n)
        Auxiliary space: O(height of tree (longest path from root to leaf node))
    */
    private void printInorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // first recur on the left of the binary tree
        printInorderTraversal(node.left);

        // print the data of the node
        System.out.print(node.data + " ");

        // first recur on the right of the binary tree
        printInorderTraversal(node.right);
    }

    /*
        Time Complexity: O(n)
        Auxiliary space: O(height of tree (longest path from root to leaf node))
    */
    private void printPostorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // first recur on the left of the binary tree
        printInorderTraversal(node.left);

        // first recur on the right of the binary tree
        printInorderTraversal(node.right);

        // print the data of the node
        System.out.print(node.data + " ");
    }

    // Time Complexity: O(N), where N is the number of nodes in the Tree.
    // Auxiliary Space: O(N)
    private void printLevelorderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorderTraversal(root);
    }

    void printInorder() {
        printInorderTraversal(root);
    }

    void printPreorder() {
        printPreorderTraversal(root);
    }

    void printLevelorder() {
        printLevelorderTraversal(root);
    }
}

public class Test {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);

        /* following is the tree after above statement

              1
            /   \
          null  null
        */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */

        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
         null  null
         */

        tree.root.left.left.left = new Node(5);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          5   null
         */

        tree.root.right.right = new Node(6);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  6
           /   \
          5   null
         */

        tree.root.right.left = new Node(7);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null   7    6
           /   \
          5   null
         */

        tree.printPreorder();
        System.out.println();

        tree.printInorder();
        System.out.println();

        tree.printPostorder();
        System.out.println();

        tree.printLevelorder();
        System.out.println();
    }
}
