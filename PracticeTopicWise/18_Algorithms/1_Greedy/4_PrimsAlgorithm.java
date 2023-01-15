import java.util.Scanner;

public class PrimsAlgorithm {

	// function which gets the minimum vertex
	public static int getMinVertex(int[] dist, boolean[] mstSet, int n) {

		// as all the distance of the vertices in the graph are infinity
		// it is just a variable to compare the dist[i] is less than infinity
		int min = Integer.MAX_VALUE;

		// variable to store the min vertex and return it
		int minVertex = 0;

		// process to get the min vertex
		for (int i = 0; i < n; i++) {

			// compare the already existing distance is less than
			// infinity or updated distance
			if (mstSet[i] == false && dist[i] < min) {
				minVertex = i;
				min = dist[i];
			}
		}

		// return the vertex with the minimum weight
		return minVertex;
	}

	// utility function which prints the MST
	public static void printGraph(int[][] graph, int[] parent, int n) {
		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " -> " + i + " wt. = " + graph[parent[i]][i]);
		}
	}

	// function which finds the MST using prim's algorithm
	public static void prims(int[][] graph, int n) {

		// array to get the minimum distance between node to node
		int[] dist = new int[n];

		// what all the nodes or vertices are included in MST
		boolean[] mstSet = new boolean[n];

		// we need to remember the parent child relationship
		// it is used to remember the edges of the MST to print it finally
		int[] parent = new int[n];

		// assign the initial values
		for (int i = 0; i < n; i++) {

			// initially all the vertices are not yet included in the MST set
			mstSet[i] = false;

			// and the distance is infinite from node to node initially
			dist[i] = Integer.MAX_VALUE;
		}

		// distance from source to source is zero
		// because we need to include the minimum weight vertices and
		// initially we only have the source vertex to be included in MST
		dist[0] = 0;

		// include the source in MST set
		mstSet[0] = true;

		// make the parent of the source vertex as -1 as itself is parent in MST
		parent[0] = -1;

		// traverse upto n-1 because the number of edges in MST = (no. of vertices)-1
		for (int i = 0; i < n - 1; i++) {

			// get the vertex with minimum edge weight
			int u = getMinVertex(dist, mstSet, n);

			// include the vertex in the mst set as it has less weight
			mstSet[u] = true;

			// process to relax adjacent vertices from u
			// (which is not yet included in MST)
			for (int j = 0; j < n; j++) {

				// Relax the vertex by:
				// 1. Checking if there exist an edge
				// 2. Check whether the vertex is included in MST set
				// 3. Weight of edge should be less than the already existing distance of vertex
				if (graph[u][j] != 0 && mstSet[j] == false && graph[u][j] < dist[j]) {
					dist[j] = graph[u][j];
					parent[j] = u;
				}
			}
		}

		// utility function which prints the MST
		printGraph(graph, parent, n);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// read the number of nodes in graph
		int n;
		System.out.println("Enter the number of nodes: ");
		n = input.nextInt();

		// read the graph or it can be called as cost matrix
		// representing the weights of the node to node
		System.out.println("Enter the cost matrix: ");
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = input.nextInt();
			}
		}

		// apply the prim's algorithm and print the MST
		prims(graph, n);

		// close the input object
		input.close();
	}
}
