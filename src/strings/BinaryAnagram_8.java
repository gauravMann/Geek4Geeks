package strings;

import java.util.Scanner;

public class BinaryAnagram_8 {

	public static int countsetbits(int n) {
		int count = 0;
		for (; n != 0; count++) {
			n &= n - 1;
		}
		return count;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int n2 = scn.nextInt();
		
		if (countsetbits(n) == countsetbits(n2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
