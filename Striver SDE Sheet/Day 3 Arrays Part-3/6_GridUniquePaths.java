// Bruteforce approach
class Solution {    
    private static int solver(int m, int n, int i, int j) {
        if (i == (m - 1) && (j == n - 1))
            return 1;
        
        if (i >= m || j >= n)
            return 0;
        
        return solver(m, n, i + 1, j) + solver(m, n, i, j + 1);
    }
    
    public int uniquePaths(int m, int n) {
        return solver(m, n, 0, 0);
    }
}

// Memoization approach
class Solution {    
    private static int solver(int m, int n, int i, int j, int[][] dp) {
        if (i == (m - 1) && (j == n - 1))
            return 1;
        
        if (i >= m || j >= n)
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        else 
            return dp[i][j] = solver(m, n, i + 1, j, dp) + solver(m, n, i, j + 1, dp);
    }
    
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        
        return solver(m, n, 0, 0, dp);
    }
}

// or Dynamic Programming approach
class Solution {    
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        
        return dp[m - 1][n - 1];                    
    }
}

// Combinatorics
class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int N = m + n - 2;
        int R = m - 1;
        for (int i = 1; i <= R; i++) {
            result = result * (N - R + i) / i;
        }

        return (int) result;
    }
}
