package arrays;

import java.util.Scanner;
/*
 * get sum of current k sized window, try to append it with
 * max subarray sum till here(given by kadane's array)
 * */
public class MaxSubArraySumAtLeastKNumbers_31 {
	// forms the kadane's  array, ith pos give max subarray sum
	// till i
	public static int[] kadanes(int[] arr) {

		int[] res = new int[arr.length];
		res[0] = arr[0];
		int omax = arr[0];
		int maxEh = arr[0];

		for (int i = 1; i < arr.length; i++) {
			maxEh = Math.max(arr[i], arr[i] + maxEh);
			// it stores max till here, not overall max
			res[i] = maxEh;
		}
		return res;
	}

	
	public static int solve(int[] arr, int k) {
		int[] kad = kadanes(arr);

		int wSum = 0;
		/* Sum of window starting at zero */
		for (int i = 0; i < k; i++) {
			wSum += arr[i];
		}
		/* Answer so far */
		int maxAnswer = wSum;

		/*
		 * wSI : window start Index 
		 * Compete 
		 * 	maxAnswer
		 *  windoSum at eI 
		 *  windowSum + kadane's till eI-1
		 *  Loop constraints special as 0th window sum is
		 *  accounted for, we start window from 1 that is why
		 *  equality sign
		 */
		// window pointer is standing at last element of new window
		
		for (int weI = k; weI < arr.length; weI++) {
			wSum = wSum - arr[weI - k] + arr[weI];
			maxAnswer = Math.max(maxAnswer, Math.max(wSum, wSum + kad[weI - k]));
		}
		return maxAnswer;
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
			int k = scn.nextInt();
			System.out.println(solve(arr,k));
		}
	}

}
