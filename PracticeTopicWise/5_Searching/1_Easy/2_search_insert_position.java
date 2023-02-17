// https://leetcode.com/problems/search-insert-position/

class Solution {
	public int searchInsert(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			} else if (nums[i] < target && i == nums.length - 1) {
				return i + 1;
			}
		}

		return 0;
	}
}

// OR

// https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        if(target>arr[end]){
            return end+1;
        }
        while(start<=end){
            int mid= start+(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return start;
    }
}