public class Test {

    // Naive approach
    // Time Complexity O(N^2)
    private static int findOdd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count % 2 != 0) {
                System.out.println(arr[i] + " ");
            }
        }

        return 0;
    }

    // Efficient one
    // Time Complexity O(N)
    private static void findOdd(int[] arr, int n) {
        int xor = 0, res1 = 0, res2 = 0;

        for (int i = 0; i < n; i++)
            xor = xor ^ arr[i];

        int sn = xor & (~(xor - 1));

        for (int i = 0; i < n; i++) {
            if ((arr[i] & sn) != 0)
                res1 = res1 ^ arr[i];
            else
                res2 = res2 ^ arr[i];
        }

        System.out.println(res1 + " " + res2);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4 };
        findOdd(arr, 6);
    }
}
