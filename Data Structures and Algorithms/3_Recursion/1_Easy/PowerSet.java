// https://practice.geeksforgeeks.org/problems/power-set4302/1/#
// Time Complexity: O(2^n)

import java.util.*;

class Solution {

	private static List<String> answer = new ArrayList<String>();

	private static void powerSetGenerator(String str, String output, int index) {
		if (index == str.length()) {
			if (output.length() > 0) {
				answer.add(output);
			}
			return;
		}

		powerSetGenerator(str, output, index + 1);
		powerSetGenerator(str, output + str.charAt(index), index + 1);
	}

	public static List<String> AllPossibleStrings(String str) {
		powerSetGenerator(str, "", 0);
		Collections.sort(answer);
		return answer;
	}

	public static void main(String[] args) {
		List<String> answer = AllPossibleStrings("dmxn");
		System.out.println(answer);
	}
}