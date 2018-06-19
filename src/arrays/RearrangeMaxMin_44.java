package arrays;

import java.util.Scanner;

public class RearrangeMaxMin_44 {

	public static void solve(int[] arr) {

		int max_element = arr[arr.length - 1] + 1;
		int minIndex = 0;
		int maxIndex = arr.length - 1;

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i] + (arr[maxIndex] % max_element) * max_element;
				maxIndex--;
			} else {
				arr[i] = arr[i] + (arr[minIndex] % max_element) * max_element;
				minIndex++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] / max_element + " ");
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
			System.out.println();
		}
	}

}
