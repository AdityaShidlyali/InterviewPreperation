/*
	Time Complexity: O(V + E)
	Space Complexity: O(V)
*/
class Solution {

    private static class Triplet {
        int row, col, time;

        Triplet(int row, int col, int time) {
        	this.row = row;
        	this.col = col;
        	this.time = time;
        }
    }
    
    private static boolean isPositionValid(int[][] grid, boolean[][] visited, int row, int col) {
    	if (row >= 0 && row < grid.length 
    	&& col >= 0 && col < grid[0].length 
    	&& grid[row][col] != 0 
    	&& grid[row][col] != 2
    	&& grid[row][col] == 1
        && !visited[row][col]) {
    		return true;
    	}
    	
    	return false;
    }
    
    private static int bfs(int[][] grid, boolean[][] visited, int m, int n) {
    	Queue<Triplet> q = new LinkedList<>();
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (grid[i][j] == 2) {
    				q.add(new Triplet(i, j, 0)); 				
    				visited[i][j] = true;
    			}
    		}
    	}
    	
    	int time = 0;
    	int[] neighborRows = new int[] {-1, 0, 1, 0};
    	int[] neighborCols = new int[] {0, 1, 0, -1};
    	while (!q.isEmpty()) {
    		int parentRow = q.peek().row;
    		int parentCol = q.peek().col;
    		int parentTime = q.peek().time;
    		q.remove();
    		
    		time = parentTime;
    		
    		for (int pos = 0; pos < 4; pos++) {
    			int neighborRow = parentRow + neighborRows[pos];
    			int neighborCol = parentCol + neighborCols[pos];
    			
    			if (isPositionValid(grid, visited, neighborRow, neighborCol)) {
    				q.add(new Triplet(neighborRow, neighborCol, parentTime + 1));
    				visited[neighborRow][neighborCol] = true;
    				grid[neighborRow][neighborCol] = 2;
    			}
    		}
    	}
    	
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		
		return time;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return bfs(grid, visited, m, n);
    }
}
