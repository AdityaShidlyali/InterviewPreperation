// https://leetcode.com/problems/longest-common-prefix/
// O(n^2)

import java.util.Scanner;

public class LeetCode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		String[] strs = new String[n];

		for (int i = 0; i < n; i++) {
			strs[0] = input.next();
		}

		input.close();
	}
}

class Solution {
	public String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			prefix = longestCommonPrefixUtil(prefix, strs[i]);
		}

		return prefix;
	}

	public static String longestCommonPrefixUtil(String str1, String str2) {
		String answer = "";

		int n1 = str1.length();
		int n2 = str2.length();

		for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j)) {
				break;
			}
			answer += str1.charAt(i);
		}

		return answer;
	}
}

// Efficient solution
/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int idx = strs[0].length();
        for(String str: strs){
            idx = Math.min(idx, str.length());
            for(int i = 0; i < idx; ++i){
                if(str.charAt(i) != strs[0].charAt(i)){
                    idx = i;
                    break;
                }
            }
        }
        return strs[0].substring(0, idx);
    }
}
*/