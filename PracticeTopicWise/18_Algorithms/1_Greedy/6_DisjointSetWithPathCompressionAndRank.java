import java.util.*;

public class DisjointSetWithPathCompressionAndRank {

	// to store the array of key and value pair
	public static class Pair {
		int key, value;

		public Pair(int _key, int _value) {
			this.key = _key;
			this.value = _value;
		}

		int getKey() {
			return key;
		}

		int getValue() {
			return value;
		}

		int getParent() {
			return key;
		}

		int getRank() {
			return value;
		}

		void setParent(int parent) {
			this.key = parent;
		}

		void setRank(int rank) {
			this.value = rank;
		}
	}

	// disjoint set find operation
	public static int find(int node, ArrayList<Pair> parent) {

		if (parent.get(node).getParent() == -1) {

			// if the parent of node is -1 then node itself is absolute parent
			return node;
		}

		// if the parent of "node" is not -1 then
		// recursively get the absolute parent of the "node"
		// and also compress the path by setting the parent of "node" to absolute parent
		parent.get(node).setParent(find(parent.get(node).getParent(), parent));
		return parent.get(node).getParent();

		// iterative approach
		// while (parent.get(node).getParent() != -1) {
		// node = parent.get(node).getParent();
		// }
		// return node;
	}

	// disjoint set union operation
	public static void union(int from, int to, ArrayList<Pair> parent) {
		if (parent.get(from).getRank() > parent.get(to).getRank()) {
			parent.get(to).setParent(from);
		} else if (parent.get(from).getRank() < parent.get(to).getRank()) {
			parent.get(from).setParent(to);
		} else {
			parent.get(from).setParent(to);
			parent.get(to).setRank(parent.get(to).getRank() + 1);
		}
	}

	// function to detect graph is cyclic or not
	public static boolean isCyclic(ArrayList<Pair> edgeList, ArrayList<Pair> parent) {

		// iterate over the edgeList (graph)
		for (int i = 0; i < edgeList.size(); i++) {

			// perform find operation
			// to check whether "from" vertex is belong to same set or not
			int from = find(edgeList.get(i).getKey(), parent);

			// perform find operation
			// to check whether "to" vertex is belong to same set or not
			int to = find(edgeList.get(i).getValue(), parent);

			// if they are from the same set then there exist a cycle in graph
			if (from == to) {
				return true;
			}

			// if they are not from the same set
			// then find the union between "from" node to "to" node
			union(from, to, parent);
		}

		// and return as false as there exist no cycle in graph
		return false;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// get the number of vertices
		System.out.println("Enter the number of vertices: ");
		int nv = input.nextInt();

		// get the number of edges
		System.out.println("Enter the number of edges: ");
		int ne = input.nextInt();

		// input the edge list
		System.out.println("Enter the edgelist of " + ne + " no. of edges for " + nv + " no of vertices");
		ArrayList<Pair> edgeList = new ArrayList<Pair>(ne);
		int from, to;
		for (int i = 0; i < ne; i++) {
			from = input.nextInt();
			to = input.nextInt();
			edgeList.add(new Pair(from, to));
		}

		// initially all the nodes are of independent sets so we represent using -1
		ArrayList<Pair> parent = new ArrayList<Pair>(nv);
		for (int i = 0; i < nv; i++) {
			parent.add(new Pair(-1, 0));
		}

		// perform the disjoint set operation and find whether the entered graph is
		// cyclic or not
		boolean result = isCyclic(edgeList, parent);
		System.out.println("Graph is cyclic: " + result);

		input.close();
	}
}