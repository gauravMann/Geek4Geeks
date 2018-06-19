package arrays;

import java.util.Scanner;

public class SpaceOptimization_46 {
	public static boolean checkBit(int[] strg, int index) {
		if ((strg[index >> 5] & (1 << (index & 31))) == (1 << (index & 31))) {
			return true;
		}
		return false;
	}

	public static void setBit(int[] strg, int index) {
		strg[index >> 5] |= (1 << (index & 31));
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int k = scn.nextInt();
		scn.close();
		// int diff = (int)Math.abs(b-a);
		double sz = (b - a) / 32.0;
		int size = (int) Math.ceil(sz);
		int[] strg = new int[size];

		for (int i = a; i <= b; i++) {
			if (i % k == 0) {
				setBit(strg, i - a);
			}
		}
		for (int i = 0; i < strg.length; i++) {
			System.out.print(strg[i] + " ");
		}
		System.out.println();
		for (int i = a; i <= b; i++) {
			if (checkBit(strg, i - a)) {
				System.out.print(i + " ");
			}
		}
	}
}
