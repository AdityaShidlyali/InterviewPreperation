// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

import java.util.*;

public class Test1 {

	public static int distinctKRemoval(int[] arr, int k) {
		Map<Integer, Integer> l = new LinkedHashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (l.containsKey(arr[i])) {
				l.put(arr[i], l.get(arr[i]) + 1);
			} else {
				l.put(arr[i], 1);
			}
		}

		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(l.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}

		});

		LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
		
		for (Map.Entry<Integer, Integer> e: list) {
			sortedMap.put(e.getKey(), e.getValue());
		}
		
		for (Integer i : sortedMap.keySet()) {
			if (l.get(i) <= k) {
				k -= l.get(i);
				l.remove(i);
			}
		}
		
		return l.size();
	}

	public static void main(String[] args) {

	}
}

// or

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

