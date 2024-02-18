// https://leetcode.com/problems/rotate-array/description/
class Solution {
    public void rotate(int[] nums, int k) {
        /*  Bruteforce:
            Time complexity: O(N)
            Space complexity: O(N) for auxiliary array.

            int n = nums.length;
            k %= n;
            if (n == 1) {
                return;
            }

            int[] reversed = new int[n];

            int copyIndex = 0;
            for (int i = n - k; i < n; i++) {
                reversed[copyIndex++] = nums[i];
            }

            for (int i = 0; i <= n - k - 1; i++) {
                reversed[copyIndex++] = nums[i];
            }

            for(int i = 0; i < n; i++) {
                nums[i] = reversed[i];
            }
        */

        /*
            Optimised approach:
            Time Complexity: O(N)
            Space Complexity: O(1)
        */
        int n = nums.length;
        k %= n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    private void reverseArray(int[] arr, int low, int high) {
        while (low <= high) {
            swapArrayElement(arr, low, high);
            low++;
            high--;
        }
    }

    private void swapArrayElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
