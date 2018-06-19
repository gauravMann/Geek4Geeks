package bitManipulation;

import java.util.Scanner;

public class TwoNonRepeating_1 {

	public static int[] repeatAndMissing(int[] arr) {

		int num2 = 0;
		int num1 = 0;
		int xorTotal = 0;

		for (int i = 0; i < arr.length; i++) {
			xorTotal ^= arr[i];
		}
		int xorLastSetBit = xorTotal & ~(xorTotal - 1);

		for (int i = 0; i < arr.length; i++) {
			if ((xorLastSetBit & arr[i]) == xorLastSetBit) {
				num1 ^= arr[i];
			} else {
				num2 ^= arr[i];
			}
		}
		int[] repMis = { num1, num2 };
		return repMis;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();
			//int[] arr = new int[2*n+2]; geeks
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int[] answer = repeatAndMissing(arr);
			System.out.println(answer[0] + " " + answer[1]);

		}
	}

}
