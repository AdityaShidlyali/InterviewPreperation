import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KruskalAlgorithm {

	static class Node {
		int parent, rank;

		Node(int _parent, int _rank) {
			this.parent = _parent;
			this.rank = _rank;
		}
	}

	static class Edge implements Comparable<Edge> {
		int source, destination, weight;

		Edge(int _source, int _destination, int _weight) {
			this.source = _source;
			this.destination = _destination;
			this.weight = _weight;
		}

		@Override
		public int compareTo(Algorithm.Edge o) {
			return this.weight - o.weight;
		}
	}

	// utility function for disjoint set find operation
	// which is used to get the absolute parent of the node
	private static int find(int node, ArrayList<Node> nodes) {
		if (nodes.get(node).parent == -1) {
			return node;
		}
		return find(nodes.get(node).parent, nodes);
	}

	// utility function for disjoint set union operation
	// to find the union of two sets of nodes
	private static void unionOperation(int from, int to, ArrayList<Node> nodes) {
		if (nodes.get(from).rank > nodes.get(to).rank) {
			nodes.get(to).parent = from;
		} else if (nodes.get(from).rank < nodes.get(to).rank) {
			nodes.get(from).parent = to;
		} else {
			nodes.get(to).parent = from;
			nodes.get(from).rank += 1;
		}
	}

	private static void kruskalAlgorithm(ArrayList<Edge> edgeList, ArrayList<Node> nodes, int ne, int nv) {
		int i = 0, j = 0, from, to;

		// which keeps track of what all the edges are included in the final MST
		ArrayList<Edge> mstSet = new ArrayList<Edge>();

		// iterate through (nv - 1) edges
		// and ne number of edges
		while ((i < nv - 1) && (j < ne)) {

			// apply find operation
			// whether the vertex belongs to same set or not
			// this is because if we include this vertex whether they form
			// cycle in the graph
			from = find(edgeList.get(j).source, nodes);
			to = find(edgeList.get(j).destination, nodes);

			// if they are equal or belongs to same
			// set, then they form a cycle. Don't include them and continue
			if (from == to) {
				j++;
				continue;
			}

			// add the vertices in the MST
			mstSet.add(edgeList.get(j));

			// apply union operation on these vertices
			unionOperation(from, to, nodes);

			i++;
		}

		// print the MST
		printMst(mstSet);
	}

	// utility function to print the MST
	private static void printMst(ArrayList<Edge> mstSet) {
		for (Edge edge : mstSet) {
			System.out.println(
					"Source: " + edge.source + " Destination: " + edge.destination + " Weight: " + edge.weight);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// input the number of edges
		System.out.println("Enter the number of edges: ");
		int ne = input.nextInt();

		// input the number of vertices
		System.out.println("Enter the number of vertices: ");
		int nv = input.nextInt();

		// input the number of edge list
		System.out.println("Enter " + ne + " no. of edges for " + nv + " no. of vertices: ");
		System.out.println("Also enter corresponding weights: ");
		ArrayList<Edge> edgeList = new ArrayList<Edge>(ne);
		int from, to, weight;
		for (int i = 0; i < ne; i++) {
			from = input.nextInt();
			to = input.nextInt();
			weight = input.nextInt();

			edgeList.add(new Edge(from, to, weight));
		}

		// sort the edge list according to their weight
		Collections.sort(edgeList);

		// initially the edges are not included in the MST and also their rank is 0
		ArrayList<Node> nodes = new ArrayList<Node>(nv);
		for (int i = 0; i < nv; i++) {
			nodes.add(new Node(-1, 0));
		}

		// apply the kruskals algorithm
		kruskalAlgorithm(edgeList, nodes, ne, nv);

		input.close();
	}
}