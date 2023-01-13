
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyKnapsack2 {

    public static double getMaxProfit(int[] wt, int[] pr, int capacity) {
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], pr[i], i);
        }

        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;

        for (ItemValue i : iVal) {
            int curWt = (int) i.wt;
            int curPr = (int) i.pr;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curPr;
            } else {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curPr * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {

        Double cost;
        double wt, pr, ind;

        public ItemValue(int wt, int pr, int ind) {
            this.wt = wt;
            this.pr = pr;
            this.ind = ind;
            this.cost = (double) pr / (double) wt;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = input.nextInt();

        System.out.print("Enter capacity of the knapsack: ");
        int capacity = input.nextInt();

        System.out.println("Enter the weights of each items: ");
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = input.nextInt();
        }

        System.out.println("Enter the profits of each items: ");
        int[] pr = new int[n];
        for (int i = 0; i < n; i++) {
            pr[i] = input.nextInt();
        }

        System.out.println("The maximum profit is: " + getMaxProfit(wt, pr, capacity));
    }
}
