package arrays;

import java.util.Scanner;

public class TrappingRainWater_9 {

	public static int solve(int[] arr) {
		int water = 0;
		int peakIndex = findMaxPeakIndex(arr);

		int peakSofar = 0;

		// traverse from left
		for (int i = 1; i < peakIndex; i++) {
			if (arr[i] > arr[peakSofar]) {
				peakSofar = i;
			} else {
				water += arr[peakSofar] - arr[i];
			}
		}

		// traverse from right
		peakSofar = arr.length - 1;
		
		for (int i = arr.length - 2; i > peakIndex; i--) {
			if (arr[i] > arr[peakSofar]) {
				peakSofar = i;
			} else {
				water += arr[peakSofar] - arr[i];
			}
		}

		return water;
	}

	public static int findMaxPeakIndex(int[] arr) {
		int maxi = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[maxi]) {
				maxi = i;
			}
		}
		return maxi;
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
