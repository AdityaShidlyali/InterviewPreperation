/*
	Time Complexity: [O(M*N)] * 4
	Space Complexity: O(M*N)
*/
class Solution {

	private static class Pair {
		int row, col;
		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static int[] rowPositions = new int[] {-1, 0, 1, 0};
	private static int[] colPositions = new int[] {0, 1, 0, -1};
	
	private static boolean isPositionValid(int[][] image, int row, int col, int newColor, int oldColor) {
		if (row < image.length && row >= 0
		&& col < image[0].length && col >= 0
// 		&& !visited[row][col]
		&& image[row][col] != newColor
		&& image[row][col] == oldColor) {
			return true;
		}
		
		return false;
	}
	
	private static void bfs(int[][] image, int i, int j, int newColor, int oldColor) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		
		image[i][j] = newColor;
		
		while (!q.isEmpty()) {
			int parentRow = q.peek().row;
			int parentCol = q.peek().col;
			q.remove();
			
			for (int pos = 0; pos < 4; pos++) {
				int newRow = parentRow + rowPositions[pos];
				int newCol = parentCol + colPositions[pos];
				
				if (isPositionValid(image, newRow, newCol, newColor, oldColor)) {
					q.add(new Pair(newRow, newCol));
				// 	visited[newRow][newCol] = true;
					
					image[newRow][newCol] = newColor;
				}
			}
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;
		int oldColor = image[sr][sc];
		boolean[][] visited = new boolean[m][n];
		
		bfs(image, sr, sc, newColor, oldColor);
		return image;
	}
}

// OR

class Solution {

	private static class Pair {
		int row, col;
		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static int[] rowPositions = new int[] {-1, 0, 1, 0};
	private static int[] colPositions = new int[] {0, 1, 0, -1};
	
	private static boolean isPositionValid(int[][] image, int row, int col, int newColor, int oldColor, boolean[][] visited) {
		if (row < image.length && row >= 0
		&& col < image[0].length && col >= 0
		&& !visited[row][col]
		&& image[row][col] != newColor
		&& image[row][col] == oldColor) {
			return true;
		}
		
		return false;
	}
	
	private static void bfs(int[][] image, int i, int j, int newColor, int oldColor, boolean[][] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		
		image[i][j] = newColor;
		
		while (!q.isEmpty()) {
			int parentRow = q.peek().row;
			int parentCol = q.peek().col;
			q.remove();
			
			for (int pos = 0; pos < 4; pos++) {
				int newRow = parentRow + rowPositions[pos];
				int newCol = parentCol + colPositions[pos];
				
				if (isPositionValid(image, newRow, newCol, newColor, oldColor, visited)) {
					q.add(new Pair(newRow, newCol));
					visited[newRow][newCol] = true;
					
					image[newRow][newCol] = newColor;
				}
			}
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;
		int oldColor = image[sr][sc];
		boolean[][] visited = new boolean[m][n];
		
		bfs(image, sr, sc, newColor, oldColor, visited);
		return image;
	}
}

// OR

class  Solution {

	private static int[] rowPositions = new int[] {-1, 0, 1, 0};
	private static int[] colPositions = new int[] {0, 1, 0, -1};
	
	private static boolean isPositionValid(int[][] image, int row, int col, int newColor, int oldColor, boolean[][] visited) {
		if (row < image.length && row >= 0
		&& col < image[0].length && col >= 0
        && !visited[row][col]
		&& image[row][col] != newColor
		&& image[row][col] == oldColor
        ) {
			return true;
		}
		
		return false;
	}

    private static void dfs(int[][] image, int i, int j, int newColor, int oldColor, boolean[][] visited) {
        image[i][j] = newColor;
        visited[i][j] = true;

        for (int pos = 0; pos < 4; pos++) {
            int neighborRow = i + rowPositions[pos];
            int neighborCol = j + colPositions[pos];

            if (isPositionValid(image, neighborRow, neighborCol, newColor, oldColor, visited)) {
                dfs(image, neighborRow, neighborCol, newColor, oldColor, visited);
            }
        }
    }

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;
		int oldColor = image[sr][sc];
		boolean[][] visited = new boolean[m][n];

        image[sr][sc] = newColor;
        visited[sr][sc] = true;
		
		dfs(image, sr, sc, newColor, oldColor, visited);
		return image;
	}
}
