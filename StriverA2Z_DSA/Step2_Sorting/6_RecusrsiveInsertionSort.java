/*
Time Complexity: O(N2), (where N = size of the array), for the worst, and average cases.

Reason: If we carefully observe, we can notice that the recursion call will occur for n times, and for each i, inside the recursive function, the loop j runs from i to 1 i.e. i times. For, i = 1, the loop runs 1 time, for i = 2, the loop runs 2 times, and so on. So, the total steps will be approximately the following: 1 + 2 + 3 +……+ (n-2) + (n-1). The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2. The precise time complexity will be O(n2/2 + n/2). Previously, we have learned that we can ignore the lower values as well as the constant coefficients. So, the time complexity is O(n2). Here the value of n is N i.e. the size of the array.

Space Complexity: O(N) auxiliary stack space.
*/
public class Main {

    private void insertionSortRecursive(int[] arr, int i, int n) {
        if (i == n) {
            return;
        }

        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            j--;
        }

        insertionSortRecursive(arr, i + 1, n - 1);
    }

    public void main(String[] args) {
        int[] arr = new int[]{43, 23, 6, 76, 8, 98};
        int n = arr.length;

        System.out.println("Before sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        insertionSort(arr, n);

        System.out.println("\nAfter sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

