// Geeksforgeeks: https://www.geeksforgeeks.org/sum-of-elements-in-given-range-from-array-formed-by-infinitely-concatenating-given-array/
// Coding Ninjas: https://www.codingninjas.com/codestudio/problem-details/sum-of-infinite-array_873335

import java.util.Scanner;

public class Test {

	private static class Query {
		int left, right;

		Query(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	// function to get the sum in infinite ranges
	public static void sumInRanges(int[] numbers, int numberOfElements, int numberOfQueries, Query[] queries) {
		int sum = 0;
		int MOD = 1000000007;

		// process all the queries
		for (int i = 0; i < numberOfQueries; i++) {
			// for each query process the summation from left to right repeatedly with
			// modulus with the number of elements
			for (int j = queries[i].left - 1; j < queries[i].right; j++) {
				sum = (sum % MOD) + (numbers[j % numberOfElements] % MOD);
			}

			// print the result for each of the query
			System.out.println("For (" + queries[i].left + "," + queries[i].right + ") Result = " + sum);

			// make the sum=0 after processing each query
			sum = 0;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCases = input.nextInt();

		while (testCases-- != 0) {

			// get the number of elements and input those number of elements
			int numberOfElements = input.nextInt();
			int[] numbers = new int[numberOfElements];
			for (int i = 0; i < numberOfElements; i++) {
				numbers[i] = input.nextInt();
			}

			// get the number of queries and input those queries
			int numberOfQueries = input.nextInt();
			Query[] queries = new Query[numberOfQueries];
			int left, right;
			for (int i = 0; i < numberOfQueries; i++) {
				left = input.nextInt();
				right = input.nextInt();

				queries[i] = new Query(left, right);
			}

			// for each of the query solve the summation
			sumInRanges(numbers, numberOfElements, numberOfQueries, queries);
		}
		input.close();
	}
}
