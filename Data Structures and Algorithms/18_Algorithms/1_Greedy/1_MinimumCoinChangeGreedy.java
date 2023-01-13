
import java.util.ArrayList;
import java.util.Scanner;

public class MinimumCoinChangeGreedy {

    static void minimumCoins(int[] a, int rs) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int j = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            while (rs >= a[i]) {
                rs -= a[i];
                ans.add(a[i]);
            }
        }

        System.out.println("The feasible solution is: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] a = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        System.out.println("Enter the amount to get the minumum number of changes: ");
        int rs = input.nextInt();

        minimumCoins(a, rs);
    }
}
