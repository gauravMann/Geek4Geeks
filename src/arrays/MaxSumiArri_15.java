package arrays;

import java.util.Scanner;

//rotate array such that max(sum i*arr[i]) , i = 0 to length
public class MaxSumiArri_15 {

	public static int solve(int[] arr) {
		int curriSum = 0;
		int sum = 0;

		// find curr i*arr[i] sum, and sum of array
		for (int i = 0; i < arr.length; i++) {
			curriSum += i * arr[i];
			sum += arr[i];
		}

		/*
		 * Rotate array clockwise by one, max n-1 rotations possible, n th rotation gives initial array
		 *  0 1 2 3 : Indices
		 * [8 3 1 2] --> curriSum = 8 * 0 + 3 * 1 + 1 * 2 + 2 * 2, for rotation shift by 1 each element to right
		 * [2 8 3 1]-->curriSum =   2* 0      + 8 * 1 + 3 * 2 + 1 * 3
		 * rotation by 1 curriSum =(2*2+2-3*2)+(8*0+8)+(3*1+3)+(1*2+1) 
		 */
		int omax = curriSum;
		for(int i = arr.length-1; i >= 1; i--){
			curriSum = curriSum + sum - arr.length*arr[i];
			omax = Math.max(omax, curriSum);
		}
		return omax;
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
			System.out.println(solve(arr));
		}
	}

}
