
import java.util.Scanner;

class Pair {

    int min;
    int max;

    public Pair(int max, int min) {
        this.min = min;
        this.max = max;
    }
}

public class MinMax {

    public static void minMaxAux(int[] a, int low, int high, Pair pair) {

        if (low == high) { // if there is only one element in array

            if (pair.min > a[low]) {
                pair.min = a[low];
            }
            if (pair.max < a[low]) {
                pair.max = a[low];
            }
        } else if (low == high - 1) { // if the low = 0 and high = 1 this is another small case

            // check for minimum element
            if (pair.min > a[low]) {
                pair.min = a[low];
            }
            if (pair.min > a[high]) {
                pair.min = a[high];
            }

            // check for maximum element
            if (pair.max < a[low]) {
                pair.max = a[low];
            }
            if (pair.max < a[high]) {
                pair.max = a[high];
            }

        } else {

            // divide and find the minimum and maximum elements
            int mid = (low + high) / 2;

            minMaxAux(a, low, mid, pair);
            minMaxAux(a, mid + 1, high, pair);
        }
    }

    public static void minMax(int[] a, int size, Pair pair) {
        minMaxAux(a, 0, size - 1, pair);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the elements one by one: ");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        // make the minimum and maximum elements as the first elements of the array itself
        Pair pair = new Pair(a[0], a[0]);
        minMax(a, n, pair);

        System.out.println("Min element = " + pair.min + " Max element = " + pair.max);
    }
}
