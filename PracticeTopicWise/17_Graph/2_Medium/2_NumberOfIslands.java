/*
	Time Complexity: O(M * N) (M*N is Size of given grid)
	Space Complexity: O(M * N)
*/
public class Solution {
	
	private static class Pair {
		int row, column;
		public Pair(int row, int column) {
			this.row = row;
			this.column = column;	
		}
	}
	
	private static void bfs(char[][] grid, int i, int j, boolean[][] visited, int m, int n) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i, j));
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			int parentRow = q.peek().row;
			int parentCol = q.peek().column;
			q.remove();
			
			for (int rowPos = -1; rowPos <= 1; rowPos++) {
				for (int colPos = -1; colPos <= 1; colPos++) {
					int neighborRow = parentRow + rowPos;
					int neighborColumn = parentCol + colPos;
					
					if (neighborRow < m && neighborRow >= 0 
					&& neighborColumn < n && neighborColumn >= 0
					&& grid[neighborRow][neighborColumn] == '1' 
					&& !visited[neighborRow][neighborColumn]) {
						visited[neighborRow][neighborColumn] = true;
						q.add(new Pair(neighborRow, neighborColumn));
					}
				}
			}
		}
	}
	
	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					bfs(grid, i, j, visited, m, n);
					++count;
				}
			}
		}
		
		return count;
    }
}
