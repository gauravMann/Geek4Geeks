package arrays;
import java.util.Scanner;

public class ThreeWayPartition_17 {

	/*
	*
	* Apply QuickSort but in partitioning idea 
	* partition the array in three areas.Math interval notation
	*	[0, lo - 1] : elements < lowVal
	*	[lo, mid - 1]: lowVal <= elements <= hiVal
	*	[mid, high] : unknown area
	*	[high + 1, arr.length -1] : elements > hiVal
	*
	*/
	public static void partition(int[] arr, int lowVal, int hiVal) {
	
		int low = 0;
		int mid = 0;
		int high = arr.length-1;

		while (mid <= high) {

			if (lowVal<=arr[mid] && arr[mid]<= hiVal) {
				mid++;
			} else if (arr[mid] > hiVal) {
				swap(arr, mid, high);
				high--;
			} else {
				swap(arr, mid, low);
				low++;
				mid++;
			}
		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
				
	}

	public static void printArr(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
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
			int lowVal = scn.nextInt();
			int hiVal = scn.nextInt();
			partition(arr, lowVal, hiVal);
			printArr(arr);
		
		}
	}

}
