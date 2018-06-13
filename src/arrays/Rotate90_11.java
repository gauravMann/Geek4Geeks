package arrays;

import java.util.Scanner;

public class Rotate90_11 {

	public static void swap(int[][] arr, int r1, int c1, int r2, int c2) {
		int temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;
	}

	public static void colSwap(int[][] arr, int c1, int c2) {
		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, c1, i, c2);
		}
	}

	public static void rowSwap(int[][] arr, int r1, int r2) {
		for (int j = 0; j < arr[0].length; j++) {
			swap(arr, r1, j, r2, j);
		}
	}

	public static void transpose(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (j > i) {
					swap(arr, i, j, j, i);
				}
			}
		}
	}

	public static void clockwise(int[][] arr) {
		transpose(arr);
		printArr(arr);
		int left = 0;
		int right = arr[0].length - 1;
		while (left <= right) {
			colSwap(arr, left, right);
			left++;
			right--;
		}

	}

	public static void antiClockwise(int[][] arr) {
		transpose(arr);
//		printArr(arr);
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			rowSwap(arr, left, right);
			left++;
			right--;
		}

	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
//			System.out.println();
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = scn.nextInt();
				}

			}

//			clockwise(arr);
			antiClockwise(arr);
			printArr(arr);
			System.out.println();
		}
	}

}
