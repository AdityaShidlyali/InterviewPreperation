class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int p)
    {
        
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) {
                count[arr[i] - 1]++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            arr[i] = count[i];
        }
    }
}