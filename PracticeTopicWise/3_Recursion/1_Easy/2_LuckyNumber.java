// https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1/?track=P100-Recursion&batchId=238

class Solution {
	private static int counter = 2;

	public static boolean isLucky(int n) {
		if (counter > n) {
			return true;
		}

		if (n % counter == 0) {
			return false;
		}

		/**
		 * (n / counter) this gives the next position of the element to be deleted
		 * 
		 * If the input n initially is 7 then the counter value surpasses this 7 then 7
		 * is lucky,
		 * 
		 * But if the input n initially is 6 then the counter value becomes 3 and
		 * 5-(5/3) is 3 so, after deleting every 2nd element then the 5 will be in the
		 * position 3 so 5 is not lucky number
		 * 
		 */
		n = n - n / counter;
		counter++;
		return isLucky(n);
	}
}

// or
class Solution {
	public static boolean isLucky(int n) {
		for(int i=2;i<=n;i++) {
            		if(n%i==0) return false;
            		n = n - n/i;
        	}
        
        	return true;
	}
}