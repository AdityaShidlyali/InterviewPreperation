class Solution
{   
    private static long MOD = 1000000007;
	long power (int n, int r) {

		if (r == 1) { return n; }

		if (r == 0) { return 1; }

		long ans = power(n, r/2) % MOD;

		ans = (ans * ans) % MOD;

		if (r%2 == 0) { 
			return ans%MOD;
		} else { 
			return (n*ans)%MOD;
		}
	}
}