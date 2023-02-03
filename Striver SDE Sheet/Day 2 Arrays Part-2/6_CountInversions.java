// if some compiler gives TLE use following solution
class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    static long mergeAndCount(long[] arr, long[] temp, int left, int mid, int right) {
        long inversionCount = 0;
        
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1);
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        
        return inversionCount;
    }
    
    static long mergeSortAndCount(long[] arr, long[] temp, int left, int right) {
        long inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            
            inversionCount += mergeSortAndCount(arr, temp, left, mid);
            inversionCount += mergeSortAndCount(arr, temp, mid + 1, right);
            
            inversionCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return inversionCount;
    }
    
    static long inversionCount(long arr[], long n) {
        // Your Code Here
        long[] temp = new long[(int) n];
        return mergeSortAndCount(arr, temp, 0, (int)(n - 1));
    }
}


// if some compiler don't gives TLE use following solution
// because the memory allocation of temp array inside mergeAndCount function is time consuming
public class Solution {

    static int mergeAndCount(long[] arr, int left, int mid, int right) {
        long[] temp = new long[left + right + 1];
        int inversionCount = 0;
        
        int i = left, j = mid, k = left;
        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i);
            }
        }
        
        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        
        return inversionCount;
    }
    
    static int mergeSortAndCount(long[] arr, int left, int right) {
        int inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            
            inversionCount += mergeSortAndCount(arr, left, mid);
            inversionCount += mergeSortAndCount(arr, mid + 1, right);
            
            inversionCount += mergeAndCount(arr, left, mid + 1, right);
        }
        return inversionCount;
    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return mergeSortAndCount(arr, 0, (int)(n - 1));
    }
}