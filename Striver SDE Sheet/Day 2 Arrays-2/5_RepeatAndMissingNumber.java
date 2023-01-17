
// Approach 1:
public class Solution {
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        int n = a.size();
        Collections.sort(a);

        int sumOfArray = 0;
        for (int i : a)
            sumOfArray += i;

        int repeatingNumber = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a.get(i).equals(a.get(i + 1))) {
                repeatingNumber = a.get(i);
                break;
            }
        }

        long missingNumber = ((long) n * (n + 1) / 2) + repeatingNumber - sumOfArray;
        
        ArrayList<Integer> ansList = new ArrayList<>();
        ansList.add(repeatingNumber);
        ansList.add((int)missingNumber);
        
        return ansList;
    }
}
