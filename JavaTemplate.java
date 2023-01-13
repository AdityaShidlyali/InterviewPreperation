
/**
 * Author: Aditya Shidlyali
 */
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Template {

    /**
     * FastReader class
     */
    public static class FastReader {
        StringTokenizer stringTokenizer;
        BufferedReader bufferedReader;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        String nextLine() {
            String string = "";
            try {
                string = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return string;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char nextChar() {
            char ch = 0;
            try {
                ch = (char) bufferedReader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ch;
        }
    }

    /**
     * lowerBound
     */
    static int lowerBound(List<Long> list, long k) {
        int low = 0;
        int high = list.size();
        while (low != high) {
            int mid = (low + high) >> 1;
            if (list.get(mid) < k)
                low = mid + 1;
            else
                high = mid;
        }
        if (low == list.size())
            return -1;
        return low;
    }

    /**
     * upperBound
     */
    static int upperBound(List<Long> list, long k) {
        int low = 0;
        int high = list.size();
        while (low != high) {
            int mid = (low + high) >> 1;
            if (list.get(mid) <= k)
                low = mid + 1;
            else
                high = mid;
        }
        if (low == list.size())
            return -1;
        return low;
    }

    /**
     * GCD
     */
    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        else
            return gcd(b % a, a);
    }

    /**
     * LCM
     */
    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Modulus value
     */
    static int MOD = (int) (1e9 + 7);

    /**
     * Fast exponentiation with mod
     */
    static long fastExpMod(long x, long n, long mod) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;
            n = n >> 1;
        }
        return result;
    }

    /**
     * Addition mod
     */
    static long sumMod(long a, long b, long mod) {
        return ((a % mod) + (b % mod)) % mod;
    }

    /**
     * Subtraction mod
     */
    static long subMod(long a, long b, long mod) {
        return ((a - b) % mod + mod) % mod;
    }

    /**
     * Multiplication mod
     */
    static long mulMod(long a, long b, long mod) {
        return ((a % mod) * (b % mod)) % mod;
    }

    /**
     * Objects
     */
    final static FastReader fr = new FastReader();
    final static Scanner sc = new Scanner(System.in);

    /**
     * Driver function
     */
    public static void main(String[] args) throws java.lang.Exception {

        int t;
        t = 1;
//		t = input.nextInt();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
