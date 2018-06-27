package strings;

import java.util.Scanner;

public class ShortestSuperSequence_25 {

	public static void solve(String one, String two) {

		String[][] superseq = new String[one.length() + 1][two.length() + 1];

		superseq[one.length()][two.length()] = "";
		int j = two.length();
		for (int i = 0; i < one.length(); i++) {
			superseq[i][j] = one.substring(i);
		}

		int i = one.length();
		for (j = 0; j < two.length(); j++) {
			superseq[i][j] = two.substring(j);
		}

		// code starts here

		for (i = one.length() - 1; i >= 0; i--) {
			for (j = two.length() - 1; j >= 0; j--) {

				String right = superseq[i][j + 1];
				String down = superseq[i + 1][j];
				String diagnol = superseq[i + 1][j + 1];

				if (one.charAt(i) == two.charAt(j)) {
					char ch = one.charAt(i);
					superseq[i][j] = ch + diagnol;
				} else {
					if (right.length() < down.length()) {
						superseq[i][j] = two.charAt(j) + right;
					} else {
						superseq[i][j] = one.charAt(i) + down;
					}
				}
			}
		}
		System.out.println(superseq[0][0]);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String x = scn.next();
		String y = scn.next();
		solve(x,y);
	}

}
