
import java.util.Scanner;

public class QuickSort {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int hoarePartition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low, j = high;

        while (i < j) {

            while (pivot >= a[i] && i < high) {
                i++;
            }

            while (pivot < a[j]) {
                j--;
            }

            if (i < j) {
                swap(a, i, j);
            }
        }

        swap(a, low, j);
        return j;
    }

    public static void quickSortAux(int[] a, int low, int high) {
        if (low < high) {
            int j = hoarePartition(a, low, high);
            quickSortAux(a, low, j - 1);
            quickSortAux(a, j + 1, high);
        }
    }

    public static void quickSort(int[] a, int size) {
        quickSortAux(a, 0, size - 1);
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

        quickSort(a, n);

        System.out.println("Array after sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
