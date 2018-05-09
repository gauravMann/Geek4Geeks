package arrays.Rotation;

import java.util.Scanner;

public class Juggling {

	/* Rotate the array clockwise by d */
	public static void juggle(int[] arr, int d) {

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void rotateArr(int[] arr, int d) {
		int[] temp = new int[d];

		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		
		for (int i = d; i < arr.length; i++) {
			swap(arr, i, i - d);
		}

		for (int i = arr.length - d, j = 0; i < arr.length; i++, j++) {
			arr[i] = temp[j];
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();

		}

		int d = scn.nextInt();

		if (d == 0 || d == n) {
			// no rotation required
		} else if (d < n) {

			rotateArr(arr, d);
			// juggle(arr, d);

		} else {

			while (d > n) {
				d = d % n;
			}
			rotateArr(arr, d);
			juggle(arr, d);
		}

		printArray(arr);

	}

}
