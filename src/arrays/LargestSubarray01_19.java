package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestSubarray01_19 {

	public static class Pair {
		int si;
		int ei;

		public Pair(int s, int e) {
			this.si = s;
			this.ei = e;
		}
	}

	public static int solve(int[] arr) {
		/*
		 * Key : Sum
		 * Value: si,ei
		 * */
		Map<Integer, Pair> sumLen = new HashMap<>();
		int sum = 0;
		
		sumLen.put(0,new Pair(-1,-1));
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				sum -= 1;
			} else {
				sum += 1;
			}
			
			sumLen.putIfAbsent(sum, new Pair(i,i));
			sumLen.get(sum).ei = i;
		}
		
		int maxLen = 0;
		for(Map.Entry<Integer, Pair> ee : sumLen.entrySet()){
			maxLen = Math.max(maxLen,ee.getValue().ei - ee.getValue().si);
		}
		return maxLen;
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
		}
	}

}
