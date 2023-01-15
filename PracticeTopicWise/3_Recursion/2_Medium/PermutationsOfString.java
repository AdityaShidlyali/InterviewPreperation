// https://practice.geeksforgeeks.org/problems/permutations-of-a-string/1/?track=P100-Recursion&batchId=238#

class Solution {

	private static String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, str.charAt(i));
		return sb.toString();
	}

	private static void solve(String s, int index, ArrayList<String> p) {
		if (index == s.length()) {
			p.add(s);
		}

		for (int j = index; j < s.length(); j++) {
			s = swap(s, index, j);
			solve(s, index + 1, p);
			s = swap(s, j, index);
		}
	}

	public static ArrayList<String> permute(String s) {
		ArrayList<String> ans = new ArrayList<String>();
		if (s.length() == 0) {
			return ans;
		} else {
			solve(s, 0, ans);
			return ans;
		}
	}
}