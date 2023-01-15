// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {

	private static void solve(String digits, List<String> ans, StringBuilder subString, String[] mappings, int index) {
		if (index >= digits.length()) {
			ans.add(subString.toString());
			return;
		}

		/**
		 * perform the backtracking recursion
		 */

		// get the single digit from the input digits
		int digitFromDigits = digits.charAt(index) - '0';
		// use the above digit to get the corresponding mapping;
		String correspondingMapping = mappings[digitFromDigits];

		for (int i = 0; i < correspondingMapping.length(); i++) {
			subString.append(correspondingMapping.charAt(i));
			solve(digits, ans, subString, mappings, index + 1);
			subString.deleteCharAt(index);
		}
	}

	public List<String> letterCombinations(String digits) {

		List<String> ans = new ArrayList<String>();
		StringBuilder subString = new StringBuilder();
		String[] keypadMappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		if (digits.length() < 0) {
			return ans;
		} else {
			solve(digits, ans, subString, keypadMappings, 0);
		}

		return ans;
	}
}

// Another solution with HashMap
/**
class Solution {
    
    void helper(List<String> res, StringBuilder temp , Map<Character,char[]> map , char[] digits , int index){
        
        
        if(index == digits.length){
            res.add(temp.toString());
            return;
        }
        
        for(char ch : map.get(digits[index])){
            
            temp.append(ch);//DO step
            helper(res,temp,map,digits,index+1);
            temp.deleteCharAt(index);  //Undo step   
        }
    }
    
    
    public List<String> letterCombinations(String digits) {
                
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        
        if(digits.length() == 0)
            return res;
            
        Map<Character,char[]> map = new HashMap<>();
        
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        
        helper(res,temp,map,digits.toCharArray(),0);
        
        return res;
        
    }
}
/