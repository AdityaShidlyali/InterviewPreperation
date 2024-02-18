public class Main {

    /*
    * Time Complexity: O(N2), (where N = size of the array), for the worst, and average cases.
    *
    * Reason: If we carefully observe, we can notice that the recursion call, is occurring for n times,
    * and for each recursion call, the loop j runs from 0 to n-2. For, the range of size n,
    * the inner loop runs n-1 times, for the range of size n-1, the inner loop runs n-2 times, and so on.
    * So, the total steps will be approximately the following: (n-1) + (n-2) + (n-3) + ……..+ 3 + 2 + 1.
    * The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2.
    * The precise time complexity will be O(n2/2 + n/2). Previously, we have learned that we can ignore the
    * lower values as well as the constant coefficients. So, the time complexity is O(n2). Here the value of n is N i.e.
    * the size of the array.
    *
    * Space Complexity: O(N) auxiliary stack space.
    * */
    private void bubbleSort(int[] arr, int n) {
        if (n == 1) {
            return;
        }

        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        // acts as outer loop
        bubbleSort(arr, n - 1);
    }


    /*
    * Time Complexity: O(N2) for the worst and average cases and O(N) for the best case. Here, N = size of the array.
    *
    * Space Complexity: O(N) auxiliary stack space.
    * */
    private void bubbleSortOptimised(int[] arr, int n) {
        if (n == 1) {
            return;
        }

        boolean didSwap = false;
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                didSwap = true;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        // compared to non-recursive method this recursive bubble sort can be optimised in same way
        if (!didSwap) {
            return;
        }

        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{43, 23, 6, 76, 8, 98};
        int n = arr.length;

        System.out.println("Before sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        bubbleSort(arr, n);

        System.out.println("\nAfter sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
