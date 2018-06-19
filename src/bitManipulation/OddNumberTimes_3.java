package bitManipulation;

import java.util.Scanner;

public class OddNumberTimes_3 {

	public static int solve(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num ^= arr[i];
		}
		return num;
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
