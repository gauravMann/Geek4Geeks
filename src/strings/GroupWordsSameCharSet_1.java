package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GroupWordsSameCharSet_1 {

	private static void solve(String[] words) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			int key = getKey(words[i]);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>(Arrays.asList(i)));
			} else {
				map.get(key).add(i);
			}
		}

		for (Entry<Integer, ArrayList<Integer>> ee : map.entrySet()) {
			for (Integer i : ee.getValue()) {
				System.out.print(words[i] + " ");
			}
			System.out.println();
		}
	}

	private static int getKey(String s) {
		int key = 0;

		for (int i = 0; i < s.length(); i++) {
			int bitpos = s.charAt(i) - 'a';
			int mask = 1 << bitpos;
			key |= mask;
		}
		return key;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		String[] arr = new String[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next();
		}

		solve(arr);

	}

}
