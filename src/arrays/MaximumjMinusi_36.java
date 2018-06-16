package arrays;

import java.util.Scanner;

public class MaximumjMinusi_36 {

	public static int solve(int[] arr) {
		
		int[] maxTillHere = new int[arr.length];
		int[] minTillHere = new int[arr.length];
		int maxLen = -1;

		minTillHere[0] = arr[0];
		maxTillHere[maxTillHere.length - 1] = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			maxTillHere[i] = Math.max(maxTillHere[i + 1], arr[i]);
		}

		for (int i = 1; i < arr.length; i++) {
			minTillHere[i] = Math.min(minTillHere[i - 1], arr[i]);
		}

		int minP = 0;
		int maxP = 0;
		while (maxP < maxTillHere.length && minP < minTillHere.length) {
			// for geeks for geek <=
			if (minTillHere[minP] <= maxTillHere[maxP]) {
				maxLen = Math.max(maxLen, maxP - minP);
				maxP++;
			} else {

				minP++;
			}

		}
		return maxLen;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(solve(arr));
		}
	}

}
