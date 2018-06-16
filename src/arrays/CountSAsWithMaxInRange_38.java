package arrays;
import java.util.Scanner;

public class CountSAsWithMaxInRange_38 {
	/*
	 * 1. Take as input N, number of elements in array. 2. Take N inputs - Ai -
	 * as elements of array A. 3. Take as input two integers - lo and hi where
	 * lo < hi. 4. Print the count of sub-arrays in A with their maximum in the
	 * range lo to hi
	 * 
	 * Note - Use lo and hi inclusively for range comparisons i.e. lo <= max <=
	 * hi.
	 */

	public static int countSA(int[] arr, int lo, int hi) {
		
		int count = 0;
		int inc = 0;
		int exc = 0;
		
		/*count all subarrays, exclude invalid subarrays(SA)*/
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < lo) {
				inc++;
				exc++;
			} else if (arr[i] <= hi) {/*lo<= arr[i]<= hi, all prev SA are invalid*/
				inc++;
				count+= -(exc* (exc + 1)) / 2;
				exc = 0;
			} else {/*arr[i]> hi, all arrays which include this will be invalid
			 			so empty inc and exc*/
				count += (inc * (inc + 1)) / 2;
				count+= -(exc* (exc + 1)) / 2;
				inc = 0; 
				exc = 0;

			}
		}
		/*settle all scores*/
		count+= -(exc* (exc + 1)) / 2;
		count += (inc * (inc + 1)) / 2;
		return count;
	}
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		int test = scn.nextInt();
		while (test-- > 0) {
		
			int n = scn.nextInt();
			int lo = scn.nextInt();
			int hi = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(countSA(arr, lo, hi));
		}
	}

}
