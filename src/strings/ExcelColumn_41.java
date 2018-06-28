package strings;

import java.util.Scanner;

public class ExcelColumn_41 {

	public static int toNumber(String name) {
		int number = 0;
		for (int i = 0; i < name.length(); i++) {
			number = number * 26 + (name.charAt(i) - ('A' - 1));
		}
		return number;
	}

	public static String toName(int number) {
		StringBuilder sb = new StringBuilder();
		while (number-- > 0) {
			sb.append((char) ('A' + (number % 26)));
			number /= 26;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {
			int n = scn.nextInt();
			System.out.println(toName(n));
//			String str = scn.next();
//			System.out.println(toNumber(str));
		}
	}
}
