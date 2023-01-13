class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        char firstChar = word.charAt(0);
        char secondChar = word.charAt(1);
        
        if (Character.isLowerCase(firstChar) && Character.isUpperCase(secondChar)) {
            return false;
        }

        if (Character.isUpperCase(firstChar) && Character.isUpperCase(secondChar)) {
            for (int i = 2; i < word.length(); i++) {
                char iChar = word.charAt(i);
                if (Character.isLowerCase(iChar)) {
                    return false;
                }
            }
        } else if (Character.isUpperCase(firstChar) && Character.isLowerCase(secondChar)) {
            for (int i = 2; i < word.length(); i++) {
                char iChar = word.charAt(i);
                if (Character.isUpperCase(iChar)) {
                    return false;
                }
            }
        } else {
            for (int i = 2; i < word.length(); i++) {
                char iChar = word.charAt(i);
                if (Character.isUpperCase(iChar)) {
                    return false;
                }
            }
        }

        return true;
    }
}