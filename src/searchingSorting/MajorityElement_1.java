package searchingSorting;

import java.util.Scanner;

public class MajorityElement_1 {

	public static int solve(int[] arr) {
		int count = 1;
		int posMaj = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == posMaj) {
				count++;
			} else if (arr[i] != posMaj && count != 0) {
				count--;
			} else if (count == 0) {
				posMaj = arr[i];
				count = 1;
			}
		}

		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == posMaj) {
				count++;
			}
		}
		if (count >= (arr.length / 2) + 1) {
			return posMaj;
		} else {
			return -1;
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

			int maj = solve(arr);
			if (maj == -1) {
				System.out.println("NO Majority Element");
			} else {
				System.out.println(maj);
			}
		}
	}

}
