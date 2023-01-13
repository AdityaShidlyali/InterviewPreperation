public class Test {

    private static int countTotalSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {

            int k = i;

            while (k != 0) {
                if ((k & 1) == 1) {
                    count++;
                }

                k >>= 1;
            }
        }
        return count;
    }

    // Brian and Kerningham algorithm
    // Time Complexity O(number of set bits)
    private static int countTotalSetBits2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k > 0) {
                k &= (k - 1);
                count++;
            }
        }
        return count;
    }

    private static int[] countTotalSetBits3(int n) {
        int[] ans = new int[n + 1];
        int j = 0, count = 0;

        for (int i = 0; i <= n; i++) {
            int k = i;
            while (k > 0) {
                k &= (k - 1);
                count++;
            }

            ans[j++] = count;
        }

        return ans;
    }

    // using the most efficient approach to solve the counting of the set bits
    // Time complexity: O(n)
    private static int[] countTotalSetBits4(int n) {
        int[] memoizationArray = new int[n + 1];

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            memoizationArray[i] = memoizationArray[i / 2] + i % 2;
            sum += memoizationArray[i];
        }

        return memoizationArray;
    }

    public static void main(String[] args) {
        System.out.println(countTotalSetBits4(3));
    }
}