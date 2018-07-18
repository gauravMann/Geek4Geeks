package backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class WordBreak_5 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		while (test-- > 0) {
			int n = scn.nextInt();
			HashSet<String> dict = new HashSet<>();

			for (int i = 0; i < n; i++) {
				dict.add(scn.next());
			}
			String sen = scn.next();
			solve(dict, sen, "", "");
			System.out.println();
		}
	}

	private static void solve(HashSet<String> dictionary, String ques, String sentence, String prefix) {

		if (ques.length() == 0) {
			/*
			 * prefix has something then it's not a valid answer
			 */
			if (prefix.length() == 0) {
				System.out.print("(" + sentence.trim() + ")");
			}
			return;
		}

		char firstChar = ques.charAt(0);

		if (dictionary.contains(prefix + firstChar)) {
			/* 'like' found, so empty from prefix */
			solve(dictionary, ques.substring(1), sentence + prefix + firstChar + " ", "");
			/* try to build a larger word, sam->samsung */
			solve(dictionary, ques.substring(1), sentence, prefix + firstChar);
		} else {
			solve(dictionary, ques.substring(1), sentence, prefix + firstChar);
		}
	}

}
