class Solution {
    private static int[] output;
    private static boolean[] visited;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        output = new int[n];

        visited = new boolean[n];
        Arrays.fill(visited, false);

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(adjList, 0, labels);

        return output;
    }

    private static int[] dfs(List<List<Integer>> adjList, int node, String labels) {
        int[] currCount = new int[26];

        if (visited[node]) {
            return currCount;
        }

        visited[node] = true;

        currCount[labels.charAt(node) - 'a'] = 1;

        for (int neighbor : adjList.get(node)) {
            int[] neighborCount = dfs(adjList, neighbor, labels);
            for (int i = 0; i < 26; i++) {
                currCount[i] += neighborCount[i];
            }
        }

        output[node] = currCount[labels.charAt(node) - 'a'];
        return currCount;
    }
}