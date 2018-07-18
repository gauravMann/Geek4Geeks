package backtracking;

import java.util.Scanner;
/*
 * Similar to word break, each partition must be palindrome
 * there each partition was in dictionary*/

public class PalindromicPartitions_6 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = 1;
		while (test-- > 0) {
			String ques = scn.next();
			solve(ques, "", "");
		}
	}

	private static void solve(String ques, String prefix, String sentence) {
		if (ques.length() == 0) {
			if (prefix.length() == 0) {
				System.out.println(sentence);
			}
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		prefix = prefix + ch;
		if (isPalindrome(prefix)) {
			solve(ros, "", sentence + prefix + " ");
			solve(ros, prefix, sentence);
		} else {
			solve(ros, prefix, sentence);
		}
	}

	private static boolean isPalindrome(String prefix) {
		int left = 0;
		int right = prefix.length() - 1;

		while (left <= right) {
			if (prefix.charAt(left) != prefix.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;

	}

}
