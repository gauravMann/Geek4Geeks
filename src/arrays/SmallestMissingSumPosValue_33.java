package arrays;
import java.util.Scanner;

public class SmallestMissingSumPosValue_33 {

/*
 * For any value X whose sum we have to form using elements of array
 * we claim that [1....X-1] is represented using sum of elements
 * No suppose at ith iteration we are at element y.
 * Then we have to check whether X can be formed using [1...X-1] and y
 *  y < x
 *  	(x-y) is represented in [1..X-1]: guaranteed by our  claim
 *  	(x-y) + y = x, therefore x can be represented iff y <=x
 *  	= case, simply y = x
 *  y > x
 *  	-> we have to find a sum of (x-y) from array elements to get x-y+y = x
 *  	But x-y is negative , which can never be formed from [1..X-1]
 * 
 * */
	
	
	public static int solve(int[] arr){
		// res stores current smallest positive number
		// which i have to check if it can be formed or not
		
		int res = 1;
		
		/*At any iteration we guarantee that all numbers [1..res-1]
		 * can be represented by sum of elements till i.
		 * */
		for(int i = 0; i < arr.length; i++){
			if(arr[i] <= res){
				res +=arr[i];
			}else{
				return res;
			}
		}
		return res;
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
