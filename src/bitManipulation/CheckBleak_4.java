package bitManipulation;

import java.util.Scanner;

public class CheckBleak_4 {
	public static int countSetbit(int n) {
		int count = 0;
		for (; n != 0; count++) {
			n &= n - 1;
		}
		return count;
	}

	public static int ceilLog2(int n) {
		/*
		 * Count 8--> 1000 1 4--> 0100 2 2--> 0010 3 1--> 0001 4(extra) keep
		 * dividing by 2 till it doesn't become 1
		 */

		/* to remove extra */
		n--;
		int count = 0;
		while (n > 0) {
			n >>= 1;
			count++;
		}
		return count;
	}

	public static boolean isBleak(int n) {
		for (int x = n - ceilLog2(n); x < n; x++) {
			if (x + countSetbit(x) == n) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		scn.close();
		if (isBleak(n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
