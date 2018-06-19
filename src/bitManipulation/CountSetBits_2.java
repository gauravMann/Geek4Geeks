package bitManipulation;

import java.util.Scanner;

public class CountSetBits_2 {

	public static int solve(int n) {
		
		int count = 0;
		for (; n != 0; count++) {
			n &= n - 1;
		}
		return count;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test-- > 0) {
			int n = scn.nextInt();
			System.out.println(solve(n));

		}
	}

}
