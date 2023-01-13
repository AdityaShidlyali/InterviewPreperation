import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] strs = s.split(" ");
        if (pattern.length() != strs.length)
            return false;

        HashMap<Character, String> charToString = new HashMap<Character, String>();
        HashMap<String, Character> stringToChar = new HashMap<String, Character>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = strs[i];

            if (!charToString.containsKey(c)) {
                charToString.put(c, w);
            }

            if (!stringToChar.containsKey(w)) {
                stringToChar.put(w, c);
            }

            if (!charToString.get(c).equals(w) || !stringToChar.get(w).equals(c)) {
                return false;
            }
        }

        return true;
    }
}