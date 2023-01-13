// https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1/?track=DSASP-BitMagic&batchId=154
// Time Complexity O(N)

class Solution {

	public static int swapBits(int n) {
		int evenPositionSetBitMask = 0xAAAAAAAA;
		int oddPositionSetBitMask = 0x55555555;

		int evenBitMaskAndWithN = evenPositionSetBitMask & n;
		int oddBitMaskAndWithN = oddPositionSetBitMask & n;

		evenBitMaskAndWithN >>= 1;
		oddBitMaskAndWithN <<= 1;

		return evenBitMaskAndWithN | oddBitMaskAndWithN;
	}

	public static void main(String[] args) {
		System.out.println(swapBits(23));
	}
}
