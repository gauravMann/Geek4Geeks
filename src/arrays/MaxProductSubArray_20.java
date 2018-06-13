package arrays;

import java.util.Scanner;

public class MaxProductSubArray_20 {

	public static int solve(int[] arr) {
		int pmax = arr[0];
		int pmin = arr[0];
		int pGlobal = arr[0];
		int temp = 0;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] == 0) {
				pGlobal = pGlobal < 0 ? 0 : pGlobal;
				pmax = 1;
				pmin = 1;
				continue;
			}
			temp = pmax;
			pmax = Math.max(arr[i], Math.max(arr[i] * pmax, arr[i] * pmin));
			pmin = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * pmin));
			pGlobal = Math.max(pmax, pGlobal);

		}
		return pGlobal;
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
