package backtracking;

import java.util.HashSet;
import java.util.Scanner;
/*
 * Can also be done by graphs, use bfs to simulate states
 * remove only one bracket to go to next state
 * first level where state becomes balanced is minDeletions, only
 * traverse and print all balanced of that level
 * */
public class RemoveInvalidParanthesis_4 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		solve(s);

	}

	private static void solve(String s) {
		int mind = minDeletionsToBalance(s);
//		System.out.println(mind);
		printAllBalanced(s, mind, new HashSet<String>());

	}

	private static void printAllBalanced(String s, int mind, HashSet<String> res) {
		if (mind < 0) {
			return;
		}
		if (isBalanced(s)) {
			if (!res.contains(s)) {
				res.add(s);
				System.out.println(s);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (!Character.isAlphabetic(ch)) {

				String ros = s.substring(0, i) + s.substring(i + 1);
				printAllBalanced(ros, mind - 1, res);
			}
		}

	}

	private static int minDeletionsToBalance(String s) {

		if (isBalanced(s) || s.length() == 0) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (!Character.isAlphabetic(ch)) {

				String ros = s.substring(0, i) + s.substring(i + 1);
				int res = minDeletionsToBalance(ros) + 1;

				min = Math.min(min, res);

			}
		}
		return min;
	}

	private static boolean isBalanced(String s) {
		int open = 0;
		int close = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				open++;
			}
			if (ch == ')') {
				close++;
			}
			if (close > open) {
				return false;
			}
		}

		return open == close;

	}

}
