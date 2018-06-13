package arrays;

import java.util.Scanner;

public class BringLessThanKTogetherInMinSwaps_30 {
	/* Gives the sliding window size */
	public static int countLessthanEqualK(int[] arr, int k) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				count++;
			}
		}
		return count;
	}

	/*
	 * Idea is to find a window which has maximum number of elements <=k in
	 * it.Window size can not be greater than freq(<=k) in given array.So answer
	 * is windowSize - maxCount;
	 */
	public static int solve(int[] arr, int k) {
		int windowSize = countLessthanEqualK(arr, k);

		int firstWindowCount = 0;
		for (int i = 0; i < windowSize; i++) {
			if (arr[i] <= k) {
				firstWindowCount++;
			}
		}
		/* count(<=k) in current window */
		int currentCount = firstWindowCount;
		int maxCount = firstWindowCount;

		/* equality sign as window starting from zero */
		for (int wSI = 1; wSI <= arr.length - windowSize; wSI++) {

			/* Count updates only when we add or drop <=k */
			if (arr[wSI - 1] <= k && arr[wSI + windowSize - 1] > k) {
				currentCount--;
			} else if (arr[wSI - 1] > k && arr[wSI + windowSize - 1] <= k) {
				currentCount++;
			}

			maxCount = Math.max(maxCount, currentCount);
		}
		int minSwaps = windowSize - maxCount;
		return minSwaps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int k = scn.nextInt();

			System.out.println(solve(arr, k));
		}
	}
}
