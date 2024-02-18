/*
Time Complexity: O(N*logN), where N = size of the array.

Reason: At each step, we divide the whole array, for that logN and n steps are taken for the partition() function, so overall time complexity will be N*logN.

The following recurrence relation can be written for Quick sort : 

F(n) = F(k) + F(n-1-k) 

Here k is the number of elements smaller or equal to the pivot and n-1-k denotes elements greater than the pivot.

There can be 2 cases :

Worst Case – This case occurs when the pivot is the greatest or smallest element of the array. If the partition is done and the last element is the pivot, then the worst case would be either in the increasing order of the array or in the decreasing order of the array. 

Recurrence:
F(n) = F(0)+F(n-1)  or  F(n) = F(n-1) + F(0) 

Worst Case Time complexity: O(n2) 

Best Case – This case occurs when the pivot is the middle element or near to middle element of the array.
Recurrence :
F(n) = 2F(n/2)

Time Complexity for the best and average case: O(N*logN)

Space Complexity: O(1) + O(N) auxiliary stack space.
*/
class QuickSort {

    private void swapArrayElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * we assume the last element as pivot element
     * copy the elements <= pivot to the left and elements > pivot to right of given array
     * the above operation is done using creating O(N) auxiliary space.
     * this is one of the stable partition compared to others. As it doesn't compare if the elements which are sorted.
     */
    private int naivePartition(int[] arr, int low, int high) {

        int copyIndex = 0, assumedPivot = arr[high];
        int[] partitionedArray = new int[high - low + 1];

        for (int i = low; i <= high; i++) {
            if (arr[i] < assumedPivot) {
                partitionedArray[copyIndex++] = arr[i];
            }
        }

        int pivotIndex = copyIndex; // copy the pivot index just before doing last swap
        partitionedArray[copyIndex++] = assumedPivot;

        for (int i = low; i <= high; i++) {
            if (arr[i] > assumedPivot) {
                partitionedArray[copyIndex++] = arr[i];
            }
        }

        for (int i = low; i <= high; i++) {
            arr[i] = partitionedArray[i - low];
        }

        return pivotIndex;
    }

    /**
     * in this algorithm the pivot element is always the last one.
     * by traversing the entire array we create the window of elements < pivot on the left side of the array, and elements >= pivot on the right side of the window.
     * in that window we just put the elements < pivot no matter the array is sorted or not.
     * and at last coming out of the loop we swap the pivot element just right to the window of elements < pivot.
     * in this algorithm the pivot element will have the appropriate position at the end of operation.
     * this is unstable partition compared to naive partition. As it compares if the elements which are already sorted.
     */
    private int lomutoPartition(int[] arr, int low, int high) {

        int pivotElement = arr[high], smallElementIndex = low;

        for (int largeElementIndex = low; largeElementIndex <= high - 1; largeElementIndex++) {
            if (arr[largeElementIndex] < pivotElement) {
                swapArrayElement(arr, largeElementIndex, smallElementIndex);
                smallElementIndex++;
            }
        }

        // swap the pivot element at right position, as we discussed the pivot element will have exact position in this algorithm
        swapArrayElement(arr, smallElementIndex, high);
        // and then return its index.
        return smallElementIndex;
    }

    /**
     * in this algorithm the pivot element is always the first one.
     * this algorithm involves creating of smaller and larger element windows parallelly, while creating this there is middle space which is unknown space;
     * as large elements window is created from the last index and small elements window is created from the first index.
     * and if the large and small element window meets then that meeting index is the pivot element's index.
     * this is unstable partition compared to naive partition. As it compares if the elements which are already sorted. Although it is most efficient compared to naive and lomuto partition methods.
     */
    private int hoarePartition(int[] arr, int low, int high) {
        int smallElementIndex = low, largeElementIndex = high, pivot = arr[low];
        while (true) {
            while (arr[smallElementIndex] < pivot) {
                smallElementIndex++;
            }

            while (arr[largeElementIndex] > pivot) {
                largeElementIndex--;
            }

            if (smallElementIndex >= largeElementIndex) {
                return smallElementIndex;
            }

            swapArrayElement(arr, smallElementIndex, largeElementIndex);
        }
    }

    /**
     * recursive calls have different parameters compared to other partition because;
     * with Naive partition the pivot element is already sorted while partitioning the array.
     */
    private void quickSortWithNaivePartition(int[] arr, int low, int high) {
        if (low < high) {
            int partitionedPivotIndex = naivePartition(arr, low, high);
            quickSortWithNaivePartition(arr, low, partitionedPivotIndex - 1);
            quickSortWithNaivePartition(arr, partitionedPivotIndex + 1, high);
        }
    }

    /**
     * recursive calls have different parameters compared to other partition because;
     * with Lomuto partition the pivot element is already sorted while partitioning the array.
     */
    private void quickSortWithLomutoPartition(int[] arr, int low, int high) {
        if (low < high) {
            int partitionedPivotIndex = lomutoPartition(arr, low, high);
            quickSortWithLomutoPartition(arr, low, partitionedPivotIndex - 1);
            quickSortWithLomutoPartition(arr, partitionedPivotIndex + 1, high);
        }
    }

    /**
     * recursive calls have different parameters compared to Lomuto partition because;
     * with Hoare partition the pivot element is not in sorted position while partitioning the array.
     */
    private void quickSortWithHoarePartition(int[] arr, int low, int high) {
        if (low < high) {
            int partitionedPivotIndex = hoarePartition(arr, low, high);
            quickSortWithHoarePartition(arr, low, partitionedPivotIndex);
            quickSortWithHoarePartition(arr, partitionedPivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 7, 9, 3, 10, 5};

        System.out.println("Before sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // quick sort with naive partition
        arr = new int[]{3, 2, 1, 78, 9798, 97};
        QuickSort.quickSortWithNaivePartition(arr, 0, arr.length - 1);
        System.out.println("Quick Sort With Naive Partition\nSorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // quick sort with lomuto partition
        arr = new int[]{8, 4, 7, 9, 3, 10, 5};
        QuickSort.quickSortWithLomutoPartition(arr, 0, arr.length - 1);
        System.out.println("Quick Sort With Lomuto Partition\nSorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // quick sort with hoare partition
        arr = new int[]{8, 4, 7, 9, 3, 10, 5};
        QuickSort.quickSortWithHoarePartition(arr, 0, arr.length - 1);
        System.out.println("Quick Sort With Hoare Partition\nSorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
