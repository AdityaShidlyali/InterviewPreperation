// https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1

import java.util.Scanner;

public class Test2 {

	public static int getMaxRecursively(int[] a, int idx) {

		int currMax = a[0];

		if (idx == a.length) {
			return currMax;
		}

		currMax = getMaxRecursively(a, idx + 1);

		if (currMax < a[idx]) {
			return a[idx];
		} else {
			return currMax;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of elements: ");
		int n = input.nextInt();

		System.out.println("Enter the array elements: ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = input.nextInt();
		}

		int max = getMaxRecursively(a, 0);
		System.out.println("The maximum is: " + max);

		input.close();
	}
}