// https://www.geeksforgeeks.org/position-rightmost-different-bit/

public class Test {

    // Time Complexity: O(log2(n))
    // Space Complexity: O(1)
    public static int posOfRightMostDiffBit(int m, int n) {
        if (m == n) {
            return -1;
        } else {
            int positionCount = 1;

            int xorOfGivenTwoNumbers = m ^ n;

            while (xorOfGivenTwoNumbers != 0) {
                if ((xorOfGivenTwoNumbers & 1) == 1) {
                    return positionCount;
                }

                xorOfGivenTwoNumbers = xorOfGivenTwoNumbers >> 1;

                ++positionCount;
            }

            return 0;
        }
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static int posOfRightMostDiffBit2(int m, int n) {
        return (int) Math.floor(Math.log10(Math.pow(m ^ n, 2))) + 2;
    }

    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(6, 2));
    }
}