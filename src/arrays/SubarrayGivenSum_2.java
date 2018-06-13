package arrays;

import java.util.Scanner;

public class SubarrayGivenSum_2 {

	public static void contigousArraySum(int[] arr, long target) {

		int start = 0;
		int end = 0;
		long sum = arr[0];
		boolean found = false;

		while (start < arr.length && end < arr.length) {

			if (sum > target) {
				sum -= arr[start];
				start++;

			} else if (sum == target) {
				found = true;
				break;
			} else {
				end++;
				if(end == arr.length){
				    break;
				}
				sum += arr[end];

			}

		}
		if (found) {
			System.out.println((start + 1) + " " + (end + 1));

		} else {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();
			int target = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			contigousArraySum(arr, target);
		}
	}

}
