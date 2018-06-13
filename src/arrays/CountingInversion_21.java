package arrays;

import java.util.Scanner;

public class CountingInversion_21 {

	public static int countSplitInversion(int[] arr, int start, int mid, int end) {

		int invCount = 0;

		int leftLen = mid - start + 1;
		int rightLen = end - mid;
		int[] left = new int[leftLen];
		int[] right = new int[rightLen];

		for (int i = 0; i < leftLen; i++) {
			left[i] = arr[start + i];
		}
		for (int i = 0; i < rightLen; i++) {
			right[i] = arr[mid + i + 1];
		}
		int leftP = 0;
		int rightP = 0;
		/* important detail why arrP starts from ? start */
		int arrP = start;

		while (leftP < left.length && rightP < right.length) {

			if (left[leftP] <= right[rightP]) {
				arr[arrP] = left[leftP];
				leftP++;
				arrP++;
			} else {
				invCount += left.length - leftP;
				arr[arrP] = right[rightP];
				rightP++;
				arrP++;
			}
		}
		while (leftP < left.length) {
			arr[arrP] = left[leftP];
			leftP++;
			arrP++;
		}
		while (rightP < right.length) {
			arr[arrP] = right[rightP];
			rightP++;
			arrP++;
		}
		return invCount;
	}

	public static int countInversion(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return 0;
		}
		int mid = (startIndex + endIndex) / 2;
		int left = countInversion(arr, startIndex, mid);
		int right = countInversion(arr, mid + 1, endIndex);
		int split = countSplitInversion(arr, startIndex, mid, endIndex);

		return left + right + split;

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
			System.out.println(countInversion(arr, 0, arr.length-1));
		}
	}

}
