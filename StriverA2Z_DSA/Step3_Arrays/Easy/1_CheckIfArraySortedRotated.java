/*
Time Complexity: O(N)
Space Complexity: O(1)

https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
*/
class Solution {

    public boolean check(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }

        if (nums[n - 1] > nums[0]) {
            count++;
        }

        // if all the elements in the given array are equal then count will remain zero so need to check count < 1 also.
        return count <= 1;
    }

    // the following solution works only when the array is sorted and rotated but
    // for the case [1, 2, 3] it returns false as the test case is not rotated.
    // so the thing here is the array should be rotated as well as sorted.
    public boolean checkIfArrayRotatedAndSorted(int[] nums) {
        int minIndex = 0, maxIndex = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }

            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        boolean answer = false;
        if (maxIndex == minIndex - 1) {
            answer = isIncreasingRotated(nums, n, minIndex, maxIndex);
        }

        if (minIndex == maxIndex - 1) {
            answer = isDecreasingRotated(nums, n, minIndex, maxIndex);
        }

        return answer;

        /*
            Second approach for the above solution is as follows:
            // Initializing two variables x,y as zero.
            int x = 0, y = 0;

            // Traversing array 0 to last element.
            // n-1 is taken as we used i+1.
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] < arr[i + 1])
                    x++;
                else
                    y++;
            }

            // If till now both x,y are greater
            // than 1 means array is not sorted.
            // If both any of x,y is zero means
            // array is not rotated.
            if (y == 1) {
                // Checking for last element with first.
                if (arr[n - 1] < arr[0])
                    x++;
                else
                    y++;

                // Checking for final result.
                if (y == 1)
                    return true;
            }
            *
            // If still not true then definitely false.
            return false;
        */
    }

    private boolean isIncreasingRotated(int[] nums, int n, int minIndex, int maxIndex) {
        // if the array is in increasing order and rotated then the last element is always smaller than the first element
        if (nums[0] < nums[n - 1]) {
            return false;
        }

        return isIncreasing(nums, 0, maxIndex) && isIncreasing(nums, minIndex, n - 1);
    }

    private boolean isIncreasing(int[] nums, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isDecreasingRotated(int[] nums, int n, int minIndex, int maxIndex) {
        // if the array is in decreasing order and rotated then the last element is always greater than the first element
        if (nums[0] > nums[n - 1]) {
            return false;
        }

        return isDecreasing(nums, 0, minIndex) && isDecreasing(nums, maxIndex, n - 1);
    }

    private boolean isDecreasing(int[] nums, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (nums[i - 1] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}

