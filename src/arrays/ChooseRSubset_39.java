package arrays;
import java.util.Scanner;

public class ChooseRSubset_39 {
	
	
	public static void chooseRSubsets(int[] arr, int r, String ansf, int called) {

		if (r == 0) {

			System.out.println(ansf);
			return;
		}

		for (int i = called + 1; i < arr.length; i++) {

			chooseRSubsets(arr, r - 1, ansf + arr[i] + " ", i);

		}
	}

	
	public static void chooseR(int[] arr, int vidx, int r, String ans) {
		if (vidx == arr.length) {
			return;
		}
		if (r == 0) {
			System.out.println(ans);
		}
		// yes
		chooseR(arr, vidx + 1, r - 1, ans + arr[vidx] + " ");
		// no
		chooseR(arr, vidx + 1, r, ans);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int r = scn.nextInt();
		chooseRSubsets(arr, r, new String(""), -1);
		scn.close();

//		chooseR(arr, 0, r, new String(""));
	}
}
