
class Solution {

    public static char[] reverseWordUtil(char[] ans, String str, int i, int j) {
        if (i <= j) {
            char temp = str.charAt(i);
            ans[i] = str.charAt(j);
            ans[j] = temp;

            i++;
            j--;

            ans = reverseWordUtil(ans, str, i, j);

            return ans;
        }

        return ans;
    }

    public static String reverseWord(String str) {

        int i = 0, j = str.length() - 1;
        char[] ans = new char[str.length()];

        ans = reverseWordUtil(ans, str, i, j);

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String s = "Aditya";
        System.out.println(reverseWord(s));
    }
}
