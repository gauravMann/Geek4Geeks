package arrays;

import java.util.Scanner;
import java.util.Stack;

public class MinNumberDISeuquence_32 {

	public static String solve(String s) {

		Stack<Integer> st = new Stack<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= s.length(); i++) {

			st.push(i + 1);

			if (i == s.length() || s.charAt(i) == 'I') {

				while (!st.isEmpty()) {
					sb.append(st.pop());
				}
			}
		}
		return sb.toString();

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test-- > 0) {
			String s = scn.next();
			System.out.println(solve(s));

		}
	}

}
