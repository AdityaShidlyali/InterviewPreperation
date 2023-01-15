
class Solution {

    public static int[] reverseArrayUtil(int[] arr, int i, int j) {
        if (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;

            arr = reverseArrayUtil(arr, i + 1, j + 1);

            return arr;
        }

        return arr;
    }

    public static int[] reverseArray(int[] arr) {

        int i = 0, j = arr.length - 1;

        arr = reverseArrayUtil(arr, i, j);

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
