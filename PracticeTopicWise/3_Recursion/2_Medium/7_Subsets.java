// https://leetcode.com/problems/subsets/

class Solution {
    private List<List<Integer>> subsets = new ArrayList<>();

	private void solve(int[] nums, int index, List<Integer> subset) {
		if (index == nums.length) {
			subsets.add(new ArrayList<Integer>(subset));
			return;
		}

		// don't include the number
		solve(nums, index + 1, subset);

		// include the number in the subset
		int number = nums[index];
		subset.add(number);
		solve(nums, index + 1, subset);
		subset.remove(subset.size() - 1);
	}

	public List<List<Integer>> subsets(int[] nums) {
		solve(nums, 0, new ArrayList<Integer>());
		return subsets;
	}
}