class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return minTimeRequiredDFS(adjList, 0, 0, hasApple);
    }

    private static int minTimeRequiredDFS(List<List<Integer>> adjList, int curr, int parent, List<Boolean> hasApple) {
        int time = 0;

        for (int child : adjList.get(curr)) {
            if (child == parent)
                continue;
            
            int childTime = minTimeRequiredDFS(adjList, child, curr, hasApple);

            if (childTime > 0 || hasApple.get(child)) {
                time += 2 + childTime;
            }
        }

        return time;
    }
}