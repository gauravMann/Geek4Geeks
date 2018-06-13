package arrays;

import java.util.Scanner;

public class SortZeroOne_22 {

	public static void sort(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			if (arr[start] == 0) {
				start++;
			} else if (arr[end] == 1) {
				end--;
			} else {
				swap(arr, start, end);
				start++;
				end--;
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
			sort(arr);
			printArr(arr);
		}
	}

}
