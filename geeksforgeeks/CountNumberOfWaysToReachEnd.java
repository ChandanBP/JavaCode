package com.geeksforgeeks;

import java.util.Arrays;

public class CountNumberOfWaysToReachEnd {

	public static void countNumberOfWays(int arr[]) {

		System.out.println(arr.length);

		// if array is null or empty then return
		if (arr == null || 0 == arr.length) {
			return;
		}

		// Only one element
		if (arr.length == 1) {
			System.out.println(0);
			return;
		}

		// To store the result count for each element
		int count[] = new int[arr.length];

		// Initialise count of last element to zero
		count[arr.length - 1] = 0;

		for (int i = arr.length - 2; i >= 0; i--) {

			// Direct jump from that element to end of array
			count[i]=(arr[i] == 0)?-1:0;

			if (arr[i] >= (arr.length - 1 - i)) {
				count[i]++;
			}

			for (int j = i + 1; j < arr.length && (j - i) <= arr[i]; j++) {
				if (count[j] != -1) {
					count[i] += count[j];
				}
			}

			count[i] = (count[i] == 0) ? -1 : count[i];
		}

		System.out.println(Arrays.toString(count));
	}

	public static void main(String[] args) {

		// Declare the array
		int arr[] = { 1, 3, 5, 8, 9, 1, 0, 7, 6, 8, 9 };
		countNumberOfWays(arr);
	}
}
