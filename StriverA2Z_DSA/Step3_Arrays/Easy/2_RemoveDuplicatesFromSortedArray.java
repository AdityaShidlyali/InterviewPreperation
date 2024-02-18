class Solution {
    /*
        https://leetcode.com/problems/remove-duplicates-from-sorted-array/
        
        Generally we say "non-decreasing order" if the elements in the array are
        not strictly ascending like: [1,2,3,4,5], "non-decreasing order" means array can have elements like "[1,1,2,2,3]",
        not strictly ascending. Similar is the case for "non-increasing order".
    */
    public int removeDuplicates(int[] nums) {

        /*
            Bruteforce approach:
            Time complexity: O(n*log(n))+O(n)
            Space Complexity: O(n)
            HashSet < Integer > set = new HashSet < > ();
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
            int k = set.size();
            int j = 0;
            for (int x: set) {
                arr[j++] = x;
            }
            return k;
         */

        /*
            Optimal approach:
            Time Complexity: O(N)
            Space Complexity: O(1)
         */
        int uniqueIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }

        return uniqueIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
    }
}
