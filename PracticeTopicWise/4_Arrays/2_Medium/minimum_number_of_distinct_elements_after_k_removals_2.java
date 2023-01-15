// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

import java.util.*;

public class Test1 {

	public static int distinctKRemoval(int[] arr, int k) {
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i : arr) {
			if (freq.containsKey(i)) {
				freq.put(i, freq.get(i) + 1);
			} else {
				freq.put(i, 1);
			}
		}
		
		queue.addAll(freq.values());
		
		while (k > 0) {
			k -= queue.peek();
			
			if (k >= 0) {
				queue.poll();
			}
		}
		
		return queue.size();
	}

	public static void main(String[] args) {

	}
}
