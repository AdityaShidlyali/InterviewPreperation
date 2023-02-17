class Solution {
	private static void solve(int[] arr, int t, int i, List<Integer> list, List<List<Integer>> ll) {
		if (t == 0) {
			ll.add(new ArrayList<>(list));
			return;
		}

		for (int j = i; j < arr.length; j++) {
			if (j > i && arr[j] == arr[j - 1])
				continue;
			if (arr[j] > t)
				break;

			list.add(arr[j]);
			solve(arr, t - arr[j], j + 1, list, ll);
			list.remove(list.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ll = new ArrayList();
		solve(candidates, target, 0, new ArrayList<Integer>(), ll);
		return ll;
	}
}