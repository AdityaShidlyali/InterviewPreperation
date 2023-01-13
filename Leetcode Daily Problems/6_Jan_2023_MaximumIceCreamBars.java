class Solution {

    private static int solveDP(int[] costs, int coins, int index, int[] dp) {
        if (index >= costs.length || coins == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }
 
        int pick = 0, notPick = 0;
        if (costs[index] <= coins) {
            pick = 1 + solveDP(costs, coins - costs[index], index + 1, dp);
        } else {
            notPick = solveDP(costs, coins, index + 1, dp);
        }

        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }

    public int maxIceCream(int[] costs, int coins) {
        int[] dp = new int[costs.length + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(costs);
        return solveDP(costs, coins, 0, dp);
    }
}