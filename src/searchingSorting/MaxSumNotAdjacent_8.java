package searchingSorting;

import java.util.Scanner;

public class MaxSumNotAdjacent_8 {

	public static int maxSubarraySumNonAdjacent(int[] arr) {

		/* Max sum till now, if exclude current element */
		int exclude = 0;
		/* Max sum till now, if include current element */
		int include = 0;
		int temp = 0;

		for (int i = 0; i < arr.length; i++) {

			temp = include;
			include = exclude + arr[i];
			exclude = Math.max(temp, exclude);

		}
		return Math.max(include, exclude);
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
			
			System.out.println(maxSubarraySumNonAdjacent(arr));
		}
	}

}
