// https://practice.geeksforgeeks.org/problems/power-set-using-recursion/1/?track=P100-Recursion&batchId=238#

class Solution {

	private static void solve(ArrayList<String> ansList, int index, String mainStr, String subStr) {
		if (index == mainStr.length()) {
			ansList.add(subStr);
			return;
		}

		solve(ansList, index + 1, mainStr, subStr);
		solve(ansList, index + 1, mainStr, subStr + mainStr.charAt(index));
	}

	static ArrayList<String> powerSet(String s) {
		ArrayList<String> ansList = new ArrayList<String>();
		solve(ansList, 0, s, "");
		return ansList;
	}
}