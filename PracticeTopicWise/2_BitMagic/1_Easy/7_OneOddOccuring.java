public class Test {

    // Naive approach
    private static int oneOddOccurring(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count % 2 != 0) {
                return arr[i];
            }
        }

        return 0;
    }

    private static int oneOddOccurring2(int[] arr, int n) {
        int xorOfAllElements = 0;
        for (int i = 0; i < n; i++) {
            xorOfAllElements = xorOfAllElements ^ arr[i];
        }

        return xorOfAllElements;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 20, 30};
        System.out.println(oneOddOccurring2(arr, 5));
    }
}