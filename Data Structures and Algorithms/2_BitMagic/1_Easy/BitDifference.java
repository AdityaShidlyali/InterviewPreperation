// https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/0/?track=DSASP-BitMagic&batchId=154#

public class Test {

    // Bit difference
    // Time complexity O(number of set bits of a^b)
    public static int countBitsFlip(int a, int b) {

        int xorOfNumbers = a ^ b;
        int count = 0;

        while (xorOfNumbers != 0) {
            ++count;

            xorOfNumbers = xorOfNumbers & (xorOfNumbers - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBitsFlip(10, 20));
    }
}