package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateAllPossibleSorted_34 {

	public static void solve(int[] arr1, int[] arr2, int vidx1, int vidx2, ArrayList<Integer> al) {

		if (vidx1 == arr1.length || vidx2 == arr2.length) {
			return;
		}

		if (al.size() % 2 == 0) {
			for (int i = vidx1; i < arr1.length; i++) {
				if (al.size() == 0 || arr1[i] > al.get(al.size() - 1)) {
					al.add(arr1[i]);
					solve(arr1, arr2, vidx1 + 1, vidx2, al);
					al.remove(al.size() - 1);
				}
			}

		} else {

			for (int i = vidx2; i < arr2.length; i++) {

				if (arr2[i] > al.get(al.size() - 1)) {
					al.add(arr2[i]);
					for (int x : al) {
						System.out.print(x + " ");
					}
					System.out.println();

					solve(arr1, arr2, vidx1, vidx2 + 1, al);
					al.remove(al.size() - 1);
				}
			}
		}

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();
			int[] arr1 = new int[n];

			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = scn.nextInt();
			}

			int m = scn.nextInt();
			int[] arr2 = new int[m];

			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = scn.nextInt();
			}

			solve(arr1, arr2, 0, 0, new ArrayList<Integer>());

		}
	}

}
