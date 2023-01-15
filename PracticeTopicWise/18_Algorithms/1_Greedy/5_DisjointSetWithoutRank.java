import java.util.*;

public class DisjointSetWithoutRank {

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
	}

	// disjoint set find operation
	public static int find(int node, int parent[]) {
		if (parent[node] == -1) {
			return node;
		}

		return find(parent[node], parent);

		// iterative approach
		// while (parent[node] != -1) {
		// node = parent[node];
		// }
		// return node;
	}

	// disjoint set union operation
	public static void union(int from, int to, int[] parent) {
		parent[from] = to;
	}

	// function to detect graph is cyclic or not
	public static boolean isCyclic(ArrayList<Pair> edgeList, int[] parent) {

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

		// initially all the nodes are of independent sets, so we represent using -1
		int[] parent = new int[nv];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		// perform the disjoint set operation and find whether the entered graph is
		// cyclic or not
		boolean result = isCyclic(edgeList, parent);
		System.out.println(result);

		input.close();
	}
}