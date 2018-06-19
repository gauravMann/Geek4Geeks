package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeTheMaximumDifference_28 {

	public static void solve(int[] arr, int k) {
		Arrays.sort(arr);

		int big = arr[arr.length - 1] - k;
		int small = arr[0] + k;
		if (small > big) {
			int temp = big ^ small;
			small = small ^ temp;
			big = temp ^ big; 

		}
		int gap = big - small;
		int newBig = 0;
		int newSmall = 0;
		int newGapAdd = 0;
		int newGapSub = 0;

		for (int i = 1; i < arr.length - 1; i++) {

			/*
			 * add, beat big ? update gap If big beaten this means gap increases
			 */
			newBig = Math.max(big, arr[i] + k);
			newGapAdd = newBig - small;

			/*
			 * subtract, beat small ? update gap if small beaten --> gap
			 * increases
			 */
			newSmall = Math.min(small, arr[i] - k);
			newGapSub = big - newSmall;

			// Greedy choice
			if (newGapAdd < newGapSub) {
				big = newBig;
				gap = newGapAdd;
			} else {
				small = newSmall;
				gap = newGapSub;

			}
		}
		int ans = Math.min(gap, arr[arr.length - 1] - arr[0]);
		System.out.println(ans);

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		int test = scn.nextInt();
		while (test-- > 0) {
			
			int k = scn.nextInt();
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			solve(arr, k);
			
		}
	}

}
