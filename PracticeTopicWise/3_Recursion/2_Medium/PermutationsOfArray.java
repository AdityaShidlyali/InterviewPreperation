// https://leetcode.com/problems/permutations/

// with extra space flag array to mark the taken element
class Solution {
    private static void solve(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] flag) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                ds.add(nums[i]);
                solve(nums, ds, ans, flag);
                ds.remove(ds.size() - 1);
                flag[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = false;
        }
        solve(nums, new ArrayList<Integer>(), ans, flag);
        return ans;
    }
}

// without extra space flag array
class Solution {
    private static int[] swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}

	private static void solve(int[] nums, int index, List<List<Integer>> ans) {
		if (index == nums.length) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				tempList.add(nums[i]);
			}

			ans.add(tempList);
		}

		for (int j = index; j < nums.length; j++) {
			nums = swap(nums, index, j);
			solve(nums, index + 1, ans);
			nums = swap(nums, j, index);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0) {
			return ans;
		}

		solve(nums, 0, ans);
		return ans;
	}
}