// https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
// Time Complexity: O(log2n)
// Auxiliary Space: O(1)
// the above complexities are for both the approaches

public class Test {

    public static int getFirstSetBit(int n) {
        int positionCount = 1;

        while (n > 0) {
            if ((n & 1) > 0) {
                return positionCount;
            }
            positionCount++;
            n = n >> 1;
        }

        return 0;
    }

    private static int getFirstSetBit2(int n) {
        int maskedAnswer = (n & (n - 1)) ^ n;

        int count = 0;
        while (maskedAnswer != 0) {
            count++;
            maskedAnswer = maskedAnswer >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getFirstSetBit(5));
    }
}