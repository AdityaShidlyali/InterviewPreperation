// https://leetcode.com/problems/valid-palindrome/

class Solution {

	public boolean isPalindrome(String s) {

		String convertedString = Solution.getString(s);
		convertedString = convertedString.toLowerCase();

		int i = 0, j = convertedString.length() - 1;
		int flag = 0;
		while (i <= j) {

			if (convertedString.charAt(i) != convertedString.charAt(j)) {
				flag = 0;
				break;
			} else {
				flag = 1;
			}

			i++;
			j--;
		}

		if (flag == 1) {
			return true;
		} else if (convertedString.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static String getString(String s) {
		String convertedStringAnswer = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				convertedStringAnswer = convertedStringAnswer + s.charAt(i);
			} else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				convertedStringAnswer = convertedStringAnswer + s.charAt(i);
			} else if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				convertedStringAnswer = convertedStringAnswer + s.charAt(i);
			}
		}
		return convertedStringAnswer;
	}
}

// Efficient solution
/*
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)  return false;
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            
            while (left < right && !(isLetter(s.charAt(left)) || (s.charAt(left) >= '0' && s.charAt(left) <= '9')))
            {
                left++;
            }
            while (left < right && !(isLetter(s.charAt(right)) || (s.charAt(right) >= '0' && s.charAt(right) <= '9')))
            {
                right--;
            }
            if (isLetter(s.charAt(left)) && isLetter(s.charAt(right)))
            {
                if (s.charAt(left) == s.charAt(right) || Math.abs(s.charAt(left) - s.charAt(right)) == 32)
                {
                    left++;
                    right--;
                }
                else    return false;
            }
            else
            {
                if (s.charAt(left) == s.charAt(right))
                {
                    left++;
                    right--;
                }
                else    return false;
            }

        }
        return true;
        
    }
    
    private boolean isLetter(char ch)
    {
        return (ch >='a' && ch <='z') || (ch >= 'A' && ch <='Z');
    }
}
*/