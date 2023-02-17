class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> answerMap = new HashMap<String, ArrayList<String>>();

        String sortedStringFromChars = "";
        for (String str : strs) {
            char[] charsOfStr = str.toCharArray();
            Arrays.sort(charsOfStr);
            sortedStringFromChars = String.valueOf(charsOfStr);

            if (!answerMap.containsKey(sortedStringFromChars)) {
                answerMap.put(sortedStringFromChars, new ArrayList<>());
            }

            answerMap.get(sortedStringFromChars).add(str);
        }

        return new ArrayList<>(answerMap.values());
    }
}