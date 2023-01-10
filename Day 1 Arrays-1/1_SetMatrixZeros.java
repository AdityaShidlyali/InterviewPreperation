// Approach 2:
import java.util.*;

class Solution {

    class Pair {
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }

        for (Pair pos : list) {
            makeZero(pos.i, pos.j, matrix);
        }
    }

    private static void makeZero(int i, int j, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // make row zero
        for (int col = 0; col < n; col++) {
            matrix[i][col] = 0;
        }

        // make column zero
        for (int row = 0; row < m; row++) {
            matrix[row][j] = 0;
        }
    }
}

// Approach 3.1:
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isZeroCol = false;
        boolean isZeroRow = false;
        for (int i = 0; i < matrix.length; i++) { //check the first column
            if (matrix[i][0] == 0) {
                isZeroCol = true;
                break;
            } 
        }

        for (int i = 0; i < matrix[0].length; i++) { //check the first row
            if (matrix[0][i] == 0) {
                isZeroRow = true;
                break;
            } 
        }

        for (int i = 1; i < matrix.length; i++) { //check except the first row and column
            for (int j = 1; j < matrix[0].length; j++) 
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }

        for (int i = 1; i < matrix.length; i++) { //process except the first row and column
           for (int j = 1; j < matrix[0].length; j++) 
               if (matrix[i][0] == 0 || matrix[0][j] == 0)
                   matrix[i][j] = 0;
        }

        if (isZeroCol) { //handle the first column
            for (int i = 0; i < matrix.length; i++) 
                matrix[i][0] = 0;
        }

        if (isZeroRow) { //handle the first row
            for (int i = 0; i < matrix[0].length; i++) 
                matrix[0][i] = 0;
        }
    }
}

// Approach 3.2:
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol0 = true;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) isCol0 = false;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (isCol0 == false) matrix[i][0] = 0;
        }
    }
}