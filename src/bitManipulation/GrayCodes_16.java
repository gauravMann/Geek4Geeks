package bitManipulation;

import java.util.Scanner;

public class GrayCodes_16 {

	public static int getGrayCode(int num) {
		int mask = num >> 1;
		return num ^ mask;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		String zeroes = "00000000000000000000000000000000";

		for (int i = 0; i < (1 << n); i++) {

			int ans = getGrayCode(i);

			String binaryString = Integer.toBinaryString(ans);
			int numZeroPad = n - binaryString.length();
			String zeroPad = zeroes.substring(0, numZeroPad);
			System.out.print(zeroPad + binaryString+" ");

		}

	}

}
