// Bruteforce
class Solution {

    private static int kadanesAlgorithm(int[] nums) {
        int totalSum = 0, bestMaxSum = Integer.MIN_VALUE;
        for (int i : nums) {
            totalSum += i;

            bestMaxSum = Math.max(totalSum, bestMaxSum);
            if (totalSum < 0) {
                totalSum = 0;
            }
        }

        return bestMaxSum;
    }

    private static void rotate(int[] nums, int n) {
        int temp = nums[0];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }

        nums[n - 1] = temp;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int bestMaxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            rotate(nums, n);
            bestMaxSum = Math.max(bestMaxSum, kadanesAlgorithm(nums));
        }
        return bestMaxSum;
    }
}

// Optimised Approach
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0, minSumTill = 0, maxSumTill = 0;
        int bestMinSum = Integer.MAX_VALUE, bestMaxSum = Integer.MIN_VALUE;
        for (int i : nums) {
            totalSum += i;

            minSumTill += i;
            bestMinSum = Math.min(bestMinSum, minSumTill);
            if (minSumTill > 0) minSumTill = 0;

            maxSumTill += i;
            bestMaxSum = Math.max(bestMaxSum, maxSumTill);
            if (maxSumTill < 0) maxSumTill = 0;
        }

        // if all are negative numbers then return the maximum number among all
        if (bestMaxSum < 0) return bestMaxSum;
        else {
            // else calculate the circular sum is maximum or middle part of array is maximum
            int circularSum = totalSum - bestMinSum;
            return Math.max(bestMaxSum, circularSum);
        }
    }
}

