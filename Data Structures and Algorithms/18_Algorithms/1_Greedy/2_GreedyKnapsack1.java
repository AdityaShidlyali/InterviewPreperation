
import java.util.Scanner;

public class GreedyKnapsack1 {

    public static void greedyKnapsack(int n, float m, float[] p, float[] w) {
        int i;
        float capacity = m;
        float[] ans = new float[n];

        for (i = 0; i < n; i++) {
            ans[i] = 0;
        }

        for (i = 0; i < n; i++) {
            if (w[i] <= capacity) {
                capacity -= w[i];
                ans[i] = 1;
            } else {
                break;
            }
        }

        if (i <= n) {
            ans[i] = capacity / w[i];
        }

        System.out.println("\n\nThe optimal solution is: ");
        for (i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }

        float maxp = 0, maxw = 0;
        for (i = 0; i < n; i++) {
            maxp += p[i] * ans[i];
            maxw += w[i] * ans[i];
        }

        System.out.println("\nThe maximum weight is " + maxw);
        System.out.println("The maximum profit is " + maxp);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();

        float[] p = new float[n];
        System.out.println("Enter profits: ");
        for (int i = 0; i < n; i++) {
            p[i] = input.nextFloat();
        }

        float[] w = new float[n];
        System.out.println("Enter weights: ");
        for (int i = 0; i < n; i++) {
            w[i] = input.nextFloat();
        }

        System.out.println("Enter the weight of the knapsack: ");
        float m = input.nextFloat();

        System.out.println("\nBefore arranging the elements: ");
        System.out.print("Profits: ");
        for (int i = 0; i < n; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.print("\nWights: ");
        for (int i = 0; i < n; i++) {
            System.out.print(w[i] + " ");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (p[j] / w[j] <= p[j + 1] / w[j + 1]) {

                    // swap profits
                    float temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;

                    // swap weights
                    temp = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = temp;

                }
            }
        }

        System.out.println("\n\nAfter arranging the elements: ");
        System.out.print("Profits: ");
        for (int i = 0; i < n; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.print("\nWights: ");
        for (int i = 0; i < n; i++) {
            System.out.print(w[i] + " ");
        }

        greedyKnapsack(n, m, p, w);
    }
}
