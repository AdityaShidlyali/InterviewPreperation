// Binary Exponentiation approach
class Solution {
    public double myPow(double x, int n) {
        long power = n;
        double ans = 1.0;

        if (power < 0) {
            power = (-1) * power;
        }

        while (power > 0) {
            if (power % 2 == 1) {
                ans = ans * x;
                --power;
            } else {
                x = x * x;
                power = power >> 1; // divide power by two
            }
        }

        if (n < 0) {
            ans = 1.0 / ans;
        }
        
        return ans;
    }
}