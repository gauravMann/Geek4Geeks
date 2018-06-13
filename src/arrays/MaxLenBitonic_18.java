package arrays;

import java.util.Scanner;

public class MaxLenBitonic_18 {
	/*
	 * Max len subarray of type all increasing or all decreasing or /\ / \
	 */
	public static int solve(int[] arr) {
		/*
		 * stores sum of length of bitonic subarrays ending at i
		 */
		int[] incLen = new int[arr.length];
		incLen[0] = 1;
		// default length is 1
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				incLen[i] = incLen[i - 1] + 1;
			} else {
				incLen[i] = 1;
			}
		}

		// storing in same array, so +=
		incLen[arr.length - 1] += 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
//				incLen[i] += incLen[i + 1] + 1; , 
//				+1 not needed as we already included ith ele in first traversal
				incLen[i] += incLen[i + 1];
			} else {
				incLen[i] += 1;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < incLen.length; i++) {
			max = Math.max(incLen[i], max);
		}
		return max - 1;
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
