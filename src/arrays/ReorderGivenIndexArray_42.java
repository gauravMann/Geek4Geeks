package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReorderGivenIndexArray_42 {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void reorderArray(int[] arr, int indexArray[]) {
		int i = 0;
		while (i != indexArray[i] && i < indexArray.length) {
			swap(arr, i, indexArray[i]);
			swap(indexArray, i, indexArray[i]);
			i++;
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int[] indexArr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		for (int i = 0; i < indexArr.length; i++) {
			indexArr[i] = scn.nextInt();
		}
		scn.close();

		reorderArray(arr, indexArr);
		printArray(indexArr);
	}

}
