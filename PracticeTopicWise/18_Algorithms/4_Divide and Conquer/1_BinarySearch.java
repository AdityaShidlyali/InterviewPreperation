
import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int[] a, int low, int high, int key) {

        if (low == high) {
            if (key == a[low]) {
                return low;
            } else {
                return -1;
            }
        } else if (low < high) {
            int mid = (low + high) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                return binarySearch(a, low, mid - 1, key);
            } else {
                return binarySearch(a, mid + 1, high, key);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of array elements: ");
        int n = input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the array elements one by one: ");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println("Enter the key element to search: ");
        int key = input.nextInt();

        int result = binarySearch(a, 0, n - 1, key);
        if (result == -1) {
            System.out.println("The element is not present");
        } else {
            System.out.println("The element is present at the index " + result);
        }
    }
}
