package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramSubstrings_20 {

	public static int solve(String s) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < s.length(); j++) {
				sb.append(s.charAt(j));
				putInMap(sb.toString(), map);
			}
		}
		int ans = 0;
		for (Integer n : map.values()) {
			ans += n * (n - 1) / 2;
		}
		return ans;

	}

	private static void putInMap(String subs, Map<String, Integer> map) {
		int[] fmap = new int[26];
		for (int i = 0; i < subs.length(); i++) {
			fmap[subs.charAt(i) - 'a']++;
		}
		StringBuilder rle = new StringBuilder();
		for (int i = 0; i < fmap.length; i++) {
			if (fmap[i] > 0) {
				char ch = (char) ('a' + i);
				rle.append(ch);
				rle.append(fmap[i]);
			}
		}
		map.computeIfPresent(rle.toString(), (k, v) -> v + 1);
		map.putIfAbsent(rle.toString(), 1);

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
