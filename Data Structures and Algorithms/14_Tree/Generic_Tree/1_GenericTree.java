import java.util.*;

class GenericTree {

	// class of GenericTree
	class Node {

		// data field of node
		int data;

		// all the children nodes of the root
		ArrayList<Node> children;

		// constructor of the class
		Node(int _data) {
			this.data = _data;
			children = new ArrayList<Node>();
		}
	}

	// private root to store the reference of the root of entire node
	private Node root;

	// constructor called by user
	GenericTree() {
		Scanner input = new Scanner(System.in);
		this.root = constructGenericTree(input, null, 0);
	}

	// recursive function to generate the entire generic tree
	private Node constructGenericTree(Scanner input, Node parent, int i) {

		// initial parent parameter that is root is null
		if (parent == null) {
			System.out.println("Enter the data for root Node: ");
		} else {
			// if the root is not null get the data of the ith child of the parent
			System.out.println("Enter the data for " + i + "th child of " + parent.data);
		}

		// get the data of that ith child
		int data = input.nextInt();
		Node node = new Node(data);

		// get the number of children for that ith child
		// considering the "node" as parent
		System.out.println("Enter the number of children for node " + node.data);
		int n = input.nextInt();
		for (int j = 0; j < n; j++) {

			// store the child entered recursively
			Node child = constructGenericTree(input, node, j);

			// and add the child to the current "node"
			node.children.add(child);
		}

		return node;
	}

	// public display method which dosen't accept any parameters
	// this is because the root cannot be accessed by user.
	public void display() {
		display(this.root);
	}

	// private function to display the entire generic tree
	private void display(Node node) {

		// first print the parent
		String ans = node.data + " => ";

		// then print the parent's children
		for (Node child : node.children) {
			ans += child.data + ", ";
		}

		// print the resulting string
		System.out.println(ans);

		// recursively get all the children of the current "node"
		for (Node child : node.children) {
			display(child);
		}
	}

	// public function which is called by user to get the height
	public int height() {
		return height(root);
	}

	// utility function which returns the height of generic tree
	// this is so because user cannot access the root element
	private int height(Node node) {

		// the current height should be -1
		// because we have to count the max number of edges to deepest leaf
		// so if the root node alone exists then it should be zero
		// as we return maxHeight + 1
		int maxHeight = -1;

		// for each of the child get the height recursively;
		for (Node child : node.children) {
			int childHeight = height(child);

			// compare the childHeight with available maxHeight
			if (childHeight > maxHeight) {
				maxHeight = childHeight;
			}
		}

		// return the maxHeight + 1
		return maxHeight + 1;
	}

	// public function which is called by user to get the size
	public int size() {
		return this.size(root);
	}

	// utility function which returns the size of generic tree
	// this is so because user cannot access the root element
	private int size(Node root) {
		int totalSize = 1;

		// for each of the child recursively get the count of the children
		for (Node child : root.children) {
			totalSize += size(child);
		}

		return totalSize;
	}

	// public function which is called by user to get the max
	public int max() {
		return this.max(root);
	}

	// utility function which returns the max of generic tree
	// this is so because user cannot access the root element
	private int max(Node node) {
		int currMax = node.data;

		// for each of the children recursively get the height of the children
		for (Node child : node.children) {

			int maxChild = max(child);
			// check if the current max element is
			// less than the current child element
			if (currMax < maxChild) {
				currMax = maxChild;
			}
		}

		return currMax;
	}
}

public class Main {

	public static void main(String[] args) {
		// create instance of the GenericTree
		// which in-turn triggers the constructGenericTree function
		GenericTree genericTree = new GenericTree();

		// after creating entire generic tree display the generic tree
		genericTree.display();

		// get the height of the generic tree
		System.out.println("The height of the generic tree is: " + genericTree.height());

		// print the size of the generic tree
		System.out.println("Size of the tree is: " + genericTree.size());

		// print the maximum element in the generic tree
		System.out.println("The maximum element is: " + genericTree.max());
	}

}