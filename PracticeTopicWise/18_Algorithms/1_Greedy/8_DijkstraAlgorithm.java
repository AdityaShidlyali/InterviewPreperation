import java.util.Scanner;

public class DijkstraAlgorithm {

	// utility function to get the minimum vertex available
	private static int getMinimumVertex(int[] distance, boolean[] processed, int nv) {

		// the current distance of the vertex is maximum
		int currMin = Integer.MAX_VALUE;
		// variable to store the minimum vertex
		int minVertex = 0;

		for (int i = 0; i < nv; i++) {
			// get the minimum vertex which should be less than the current distance
			// and which shouldn't be processed
			if (processed[i] == false && currMin > distance[i]) {
				minVertex = i;
				currMin = distance[i];
			}
		}

		// return the minimum vertex
		return minVertex;
	}

	// function for Dijkstra algorithm
	private static void Dijkstra(int[][] graph, int nv) {

		// array to maintain the parent relation
		int[] parent = new int[nv];

		// to store the minimum distance available from the source
		int[] distance = new int[nv];

		// keeps track of all the nodes which already included in the SPG
		boolean[] processed = new boolean[nv];

		// initially the parents are -1, distance are infinite, all nodes are not
		// processed
		for (int i = 0; i < nv; i++) {
			parent[i] = -1;
			distance[i] = Integer.MAX_VALUE;
			processed[i] = false;
		}

		// parent of source is -1
		parent[0] = -1;
		// parent has no distance
		distance[0] = 0;

		for (int i = 0; i < nv - 1; i++) {

			// get the minimum distance available
			int u = getMinimumVertex(distance, processed, nv);
			// vertex with minimum distance is processed
			processed[u] = true;

			for (int v = 0; v < nv; v++) {

				// Check:
				// 1. If there exist an edge in the graph (u to v)
				// 2. The node v should't be processed
				// 3. Adding the node should be benefited as distance(u) + graph(u, v) <
				// distance(v)
				// 4. The distance(v) shouldn't be infinite as distance(v) += graph(u, v)
				// becomes -ve
				if (graph[u][v] != 0 && processed[v] == false && distance[u] + graph[u][v] < distance[v]
						&& distance[u] != Integer.MAX_VALUE) {
					parent[v] = u;
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}

		// print the shortest path graph
		printShortestPathGraph(graph, parent, nv);
	}

	// utility function to print the shortest path graph
	private static void printShortestPathGraph(int[][] graph, int[] parent, int nv) {
		for (int i = 1; i < nv; i++) {
			System.out.println("Source: " + parent[i] + " Destination: " + i + " Weight: " + graph[parent[i]][i]);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// input the number of vertices
		System.out.println("Enter the number of vertices: ");
		int nv = input.nextInt();

		// input the graph or the cost matrix
		System.out.println("Enter the cost matrix or graph: ");
		int[][] graph = new int[nv][nv];
		for (int i = 0; i < nv; i++) {
			for (int j = 0; j < nv; j++) {
				graph[i][j] = input.nextInt();
			}
		}

		// apply Dijkstra and print the shortest path graph
		Dijkstra(graph, nv);

		input.close();
	}
}