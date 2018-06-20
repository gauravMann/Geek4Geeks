package searchingSorting;

import java.util.Scanner;

public class RepeatingAndMissing_3 {

	public static void solve(int[] arr) {
		int xorTotal = 0;
		for (int i = 0; i < arr.length; i++) {
			xorTotal ^= arr[i] ^ (i + 1);
		}

		int mask = xorTotal & ~(xorTotal - 1);
		int num1 = 0;
		int num2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & mask) == mask) {
				num1 ^= arr[i];
			} else {
				num2 ^= arr[i];
			}
		}
		for (int i = 1; i <= arr.length; i++) {
			if ((mask & i) == mask) {
				num1 ^= i;
				;
			} else {
				num2 ^= i;
			}
		}
		boolean f = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num1) {
				f = true;
				break;
			}
		}
		if (f) {
			System.out.println(num1+" "+num2);
//			System.out.println(num2);
		} else {
			System.out.println(num2+" "+num1);
//			System.out.println(num1);
		}
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

			solve(arr);
		}
	}

}
