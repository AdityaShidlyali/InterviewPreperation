
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

// Approach 2: Using XOR
class Solve {
    int[] findTwoElement(int a[], int n) {
        int xorTillN = 0;
        int xorArrayNums = 0;
        
        for (int i : a) {
            xorArrayNums ^= i;
        }
        
        for (int i = 1; i <= n; i++) {
            xorTillN ^= i;
        }
        
        int xorFinal = xorTillN ^ xorArrayNums;
        
        int rightMostSetBit = xorFinal & ~(xorFinal - 1);
        
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] & rightMostSetBit) != 0)
                x = x ^ a[i];
            else
                y = y ^ a[i];
        }
        
        for (int i = 1; i <= n; i++) {
            if ((i & rightMostSetBit) != 0)
                x = x ^ i;
            else
                y = y ^ i;
        }
        
        int xCount = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == x)
                xCount++;
        }
        
        if (xCount==0) {
            return new int[]{y, x};
        } else {
            return new int[]{x, y};
        }
    }
}
