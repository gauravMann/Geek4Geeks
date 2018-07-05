package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SmallestWindowDistinctChars_3 {

	public static int smallestWContainsAllDistinctCharsOfString(String s) {
		Set<Character> set = new HashSet<>();

		for (Character ch : s.toCharArray()) {
			set.add(ch);
		}
		int distinctChars = set.size();

		/* Frequency map of current window */
		Map<Character, Integer> wfreqMap = new HashMap<>();

		int wminLen = Integer.MAX_VALUE;
		int sI = 0;
		int eI = 0;
		char wfirst = s.charAt(sI);
		char wlast = s.charAt(eI);

		while (eI < s.length()) {

			if (wfreqMap.size() < distinctChars) {

				wfirst = s.charAt(sI);
				wlast = s.charAt(eI);

				// keep adding chars till window has all the distinct chars
				wfreqMap.computeIfPresent(wlast, (c, f) -> f + 1);
				wfreqMap.putIfAbsent(wlast, 1);
				if (wfreqMap.size() < distinctChars) {
					eI++;
				}
			}

			if (wfreqMap.size() == distinctChars) {
				wfirst = s.charAt(sI);
				wlast = s.charAt(eI);
				wminLen = Math.min(wminLen, eI - sI + 1);

				if (wfreqMap.get(wfirst) - 1 > 0) {
					wfreqMap.put(wfirst, wfreqMap.get(wfirst) - 1);
				} else {
					wfreqMap.remove(wfirst);
					if(wfreqMap.size()!=distinctChars)
						eI++;
				}
				sI++;
			}
			
		}

		System.out.println(s.substring(sI-1, eI));
		return wminLen;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {
			String s = scn.next();
			System.out.println(smallestWContainsAllDistinctCharsOfString(s));

		}
	}

}
