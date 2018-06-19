package searchingSorting;

import java.util.Scanner;

public class CeilArray_4 {

	/*
	 * Given a sorted array and a value x, the ceiling of x is the smallest
	 * element in array greater than or equal to x, and the floor is the
	 * greatest element smaller than or equal to x. Assume than the array is
	 * sorted in non-decreasing order. Write efficient functions to find floor
	 * and ceiling of x. Examples : For example, let the input array be {1, 2,
	 * 8, 10, 10, 12, 19} For x = 0: floor doesn't exist in array, ceil = 1 For
	 * x = 1: floor = 1, ceil = 1 For x = 5: floor = 2, ceil = 8 For x = 20:
	 * floor = 19, ceil doesn't exist in array
	 */

	public static int ceilingSearch(int[] arr, int lo, int hi, int key) {
		if (key <= arr[0]) {
			return 0;
		}
		if (key > arr[arr.length - 1]) {
			return -1;
		}

		int mid = (lo + hi) / 2;

		if (arr[mid] == key) {
			return mid;
		}
		/* Then ceil is either arr[mid+1] or lies in arr[mid+1...hi] */
		else if (arr[mid] < key) {
			if (mid + 1 <= hi && key < arr[mid + 1]) {
				return mid + 1;
			} else {
				return ceilingSearch(arr, mid + 1, hi, key);
			}
		}
		/* Ceil is either arr[mid] or lies in arr[lo...mid-1] */
		else {
			if (mid - 1 >= lo && key > arr[mid - 1]) {
				return mid;
			} else {
				return ceilingSearch(arr, lo, mid - 1, key);
			}
		}

	}

	/*
	 * public static int floor(int[] arr, int key) {
	 * 
	 * }
	 */

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner scn = new Scanner(System.in);
			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int key = scn.nextInt();
			scn.close();

			int ceil = ceilingSearch(arr, 0, arr.length - 1, key);
			if (ceil == -1) {
				System.out.println("ceil not found");
			} else {
				System.out.println(arr[ceil]);
			}

//			int floor = floor(arr, key);

		}
}
