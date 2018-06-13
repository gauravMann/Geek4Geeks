package arrays;

import java.util.Scanner;

public class MoveZeroesEnd_29 {

	public static void solve(int[] arr) {
		
		int cnz = 0;
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != 0) {
				swap(arr, cnz, i);
				cnz++;
				i++;
			} else {
				i++;
			}
		}
	}

	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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
			printArr(arr);
		}
	}

}
