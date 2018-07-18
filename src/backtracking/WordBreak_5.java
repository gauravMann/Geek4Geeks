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

	private static void solve(HashSet<String> dict, String ques, String prefix, String ans) {

		if (ques.length() == 0) {
			if (prefix.length() == 0) {
				System.out.print("(" + ans.trim() + ")");
			}
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		if (dict.contains(prefix + ch)) {
			solve(dict, ros, "", ans + prefix + ch + " ");
			solve(dict, ros, prefix + ch, ans);
		} else {
			solve(dict, ros, prefix + ch, ans);
		}
	}

}
