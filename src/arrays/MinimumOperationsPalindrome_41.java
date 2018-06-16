package arrays;
import java.util.Scanner;

public class MinimumOperationsPalindrome_41 {

	public static int minimumMergeOp(int[] arr) {
		int count = 0;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			if (arr[start] == arr[end]) {
				start++;
				end--;
			} else if (arr[start] < arr[end]) {
				arr[start + 1] = arr[start + 1] + arr[start];
				start++;
				count++;
			} else {
				arr[end - 1] = arr[end - 1] + arr[end];
				end--;
				count++;
			}
		}
		return count;
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
			
			System.out.println(minimumMergeOp(arr));
		}
	}

}
