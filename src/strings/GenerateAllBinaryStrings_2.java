package strings;

import java.util.Scanner;

public class GenerateAllBinaryStrings_2 {

	public static void solve(String s, int vidx, String asf) {
		if (vidx == s.length()) {
			System.out.print(asf + " ");
			return;
		}

		if (s.charAt(vidx) == '?') {
			solve(s, vidx + 1, asf + '0');
			solve(s, vidx + 1, asf + '1');

		} else {
			solve(s, vidx + 1, asf + s.charAt(vidx));
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			String s = scn.next();
			solve(s, 0, "");
			System.out.println();

		}
	}

}
