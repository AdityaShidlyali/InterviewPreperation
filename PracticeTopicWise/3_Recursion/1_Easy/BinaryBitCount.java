/*
Time Complexity: O(log n)

Auxiliary Space: O(log n)
*/
import java.util.Scanner;

public class BinaryBitCount{

    static int binaryBitsCount(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        } else {
            return binaryBitsCount((int) (Math.ceil(n / 2))) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = input.nextInt();

        System.out.println("The binary bits of " + n + " is = " + binaryBitsCount(n));
    }
}
