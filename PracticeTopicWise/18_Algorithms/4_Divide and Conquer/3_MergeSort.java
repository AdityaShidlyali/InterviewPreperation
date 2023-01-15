
import java.util.Scanner;

public class MergeSort {

    static int[] sortedArray;

    public static void mergeTwoSortedArrays(int[] a, int low, int mid, int high) {

        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                sortedArray[k++] = a[i++];
            } else {
                sortedArray[k++] = a[j++];
            }
        }

        while (i <= mid) {
            sortedArray[k++] = a[i++];
        }

        while (j <= high) {
            sortedArray[k++] = a[j++];
        }

        for (k = low; k <= high; k++) {
            a[k] = sortedArray[k];
        }
    }

    public static void mergeSortAux(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortAux(a, low, mid);
            mergeSortAux(a, mid + 1, high);
            mergeTwoSortedArrays(a, low, mid, high);
        }
    }

    public static void mergeSort(int[] a, int size) {
        mergeSortAux(a, 0, size - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of array elements: ");
        int n = input.nextInt();

        int[] a = new int[n];
        sortedArray = new int[n];

        System.out.println("Enter the array elements one by one:");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        mergeSort(a, n);

        System.out.println("Array after sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sortedArray[i] + "  ");
        }
    }
}
