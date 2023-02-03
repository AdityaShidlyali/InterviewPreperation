// Bruteforce
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (!flag) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) {
                break;
            }
        }

        return flag;
    }
}

// Binary Search approach 1:
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = (low + (high - low) / 2);

            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}

// Binary Search Approach 2:
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}