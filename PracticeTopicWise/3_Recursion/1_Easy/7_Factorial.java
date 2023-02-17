/*
Time Complexity: O(n)
Auxiliary space complexity: O(1)
*/

import java.util.Scanner;

public class Factorial {

    static int fact(int n) {
        if (n < 0) {
            return n;
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = input.nextInt();

        System.out.println("The factorial of " + n + " is = " + fact(n));
    }
}
