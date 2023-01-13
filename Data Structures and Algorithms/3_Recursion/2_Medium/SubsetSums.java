class Solution {
    private static void solve(ArrayList<Integer> arr, int i, int currSum, ArrayList<Integer> ans) {
        if (i == arr.size()) {
            ans.add(currSum);
            return;
        }

        currSum += arr.get(i);
        solve(arr, i + 1, currSum, ans);

        // while retuning from current recursion just remove the element's sum
        currSum -= arr.get(i);
        solve(arr, i + 1, currSum, ans);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(arr, 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }
}
