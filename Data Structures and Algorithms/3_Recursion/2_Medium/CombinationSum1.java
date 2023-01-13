class Solution {
 
	private static void solve(int[] arr, int n, int i, int target, List<Integer> validComb, List<List<Integer>> ans) {
 
		if(target < 0 ) return;
		
		if (i == n) {
			if (target == 0) {
				ans.add(new ArrayList<Integer>(validComb));
			}
			return;
		}
 
		if (target >= arr[i]) {
			validComb.add(arr[i]);
			solve(arr, n, i, target - arr[i], validComb, ans);
			validComb.remove(validComb.size() - 1);
		}
		
		solve(arr, n, i + 1, target, validComb, ans);
	}
 
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		solve(candidates, candidates.length, 0, target, new ArrayList<Integer>(), ans);
		return ans;
	}
}