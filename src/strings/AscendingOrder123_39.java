package strings;

import java.util.*;
import java.util.Scanner;

public class AscendingOrder123_39 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nm = new int[n];

		for (int i = 0; i < nm.length; i++) {
			nm[i] = scn.nextInt();
		}

		ArrayList<Integer> sorted = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (has123(nm[i])) {
				sorted.add(nm[i]);
			}

		}
		Collections.sort(sorted);
		System.out.println(sorted);

	}

	public static boolean has123(int num) {

		String s = Integer.toString(num, 10);
		if (s.contains("1") && s.contains("2") && s.contains("3")) {
			return true;
		}

		return false;
	}

}
