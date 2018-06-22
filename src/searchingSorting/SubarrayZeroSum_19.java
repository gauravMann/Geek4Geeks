package searchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayZeroSum_19 {

	public static void solve(int[] arr) {

		Map<Integer, ArrayList<Integer>> sumMap = new HashMap<>();

		ArrayList<Integer> ls = new ArrayList<>();
		ls.add(-1);
		sumMap.put(0, ls);

		int cSum = 0;
		for (int i = 0; i < arr.length; i++) {
			cSum += arr[i];

			if (!sumMap.containsKey(cSum)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				sumMap.put(cSum, list);
			} else {

				sumMap.get(cSum).add(i);
				System.out.println(sumMap.get(cSum));

			}
		}

		ArrayList<Integer> keys = new ArrayList<>(sumMap.keySet());
		Collections.sort(keys);
		int count = 0;
		for (int key : keys) {
			ArrayList<Integer> getal = sumMap.get(key);
			// print all the pairs
			// System.out.println(key+" "+ getal);
			for (int i = 0; i < getal.size(); i++) {
				for (int j = i + 1; j < getal.size(); j++) {
					System.out.println(getal.get(i) + 1 + " " + getal.get(j));
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			solve(arr);
		}
	}

}
