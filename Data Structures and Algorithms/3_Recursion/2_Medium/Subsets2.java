// https://leetcode.com/problems/subsets-ii/
class Solution {
    private static void solve(int[] nums, int index, ArrayList<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            ds.add(nums[i]);
            solve(nums, i + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}

class Solution {
    private static void solve(int[] nums, int index, ArrayList<Integer> ds, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        
        ds.add(nums[index]);
        solve(nums, index + 1, ds, ans);
        ds.remove(ds.size() - 1);
        
        // skip the duplicates occurring
        while (index + 1 != nums.length && nums[index] == nums[index + 1]) index++;
        solve(nums, index + 1, ds, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}