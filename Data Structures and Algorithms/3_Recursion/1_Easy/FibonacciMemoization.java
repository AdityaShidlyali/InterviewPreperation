
import java.util.Scanner;

public class FibonacciMemoization {

    static int[] m;

    static int fibMemo(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (n == m[n]) {
                return m[n];
            } else {
                m[n] = fibMemo(n - 1) + fibMemo(n - 2);
                return m[n];
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = input.nextInt();

        // size is n + 1, because for each recursion call there will be only one extra call
        m = new int[n + 1];

        System.out.println("The " + n + "th Fibonacci is" + " is = " + fibMemo(n));
    }
}
