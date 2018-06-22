package searchingSorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortCountSetBit_25 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int n = getmax(arr);
		int count = (int) (Math.log(n) / Math.log(2))+1;

		Arrays.sort(arr);
		Map<Integer, ArrayList<Integer>> bitMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int countsetbits = kerninghamCountBit(arr[i]);
			if (!bitMap.containsKey(countsetbits)) {
				ArrayList<Integer> ls = new ArrayList<>();
				ls.add(arr[i]);
				bitMap.put(countsetbits, ls);
			} else {
				ArrayList<Integer> ls = bitMap.get(countsetbits);
				ls.add(arr[i]);
				bitMap.put(countsetbits, ls);

			}
		}

		for (int i = count; i >= 0; i--) {
			if (bitMap.containsKey(i)) {
				for (int val : bitMap.get(i)) {
					System.out.print(val + " ");
				}
			}
		}
	}

	private static int getmax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	private static int kerninghamCountBit(int n) {
		int count = 0;
		for (; n != 0; count++) {
			n &= n - 1;
		}
		return count;
	}

}
