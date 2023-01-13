/*
Time Complexity: T(n)
Auxiliary space complexity: O(1)
*/

import java.util.Scanner;

public class Fibonacci {

    static int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = input.nextInt();

        System.out.println("The " + n + "th Fibonacci is" + " is = " + fib(n));
    }
}
