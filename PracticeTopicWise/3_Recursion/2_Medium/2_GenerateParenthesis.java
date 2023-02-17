// https://leetcode.com/problems/generate-parentheses/

class Solution {

	private static void backtrack(int n, int openCount, int closeCount, String str,
			List<String> ansContainingParenthesis) {
		if (openCount == n && openCount == closeCount && closeCount == n) {
			ansContainingParenthesis.add(str);
			return;
		}

		if (openCount < n) {
			backtrack(n, openCount + 1, closeCount, str + "(", ansContainingParenthesis);
		}

		if (openCount > closeCount) {
			backtrack(n, openCount, closeCount + 1, str + ")", ansContainingParenthesis);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> ansContainingParenthesis = new ArrayList<String>();
		backtrack(n, 0, 0, "", ansContainingParenthesis);
		return ansContainingParenthesis;
	}
}
