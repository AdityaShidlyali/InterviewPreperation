class Solution {
    
    private static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for (Integer neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }
    
    private static void bfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        
        while (!q.isEmpty()) {
            Integer front = q.poll();
            
            for (Integer neighbour : graph.get(front)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // change the adjecnecy matrix to adjecency list
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
                ++count;
            }
        }
        
        return count;
    }
}