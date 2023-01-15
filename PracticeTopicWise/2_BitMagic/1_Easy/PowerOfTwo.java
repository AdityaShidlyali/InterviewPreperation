public class Test {

    private static boolean powerOfTwo(int n) {
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    private static boolean powerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    private static boolean powerOfTwo3(int n) {

        if (n == 1) return true;

        if (n % 2 != 0 || n <= 0) return false;

        int x = n / 2;

        while (x > 1) {

            if (x % 2 != 0) {
                return false;
            }
            
            x = x / 2;
        }

        return true;
    }

    private static boolean powerOfTwo4(int n) {

        if (n < 1) return false;

        if (n == 1) return true;

        while ((n & 1) != 1) {
            n >>= 1;
        }

        return n <= 1;
    }

    public static void main(String[] args) {
        System.out.println(powerOfTwo(4));
    }
}