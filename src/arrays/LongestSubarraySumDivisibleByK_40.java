package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarraySumDivisibleByK_40 {

	public static class Pair {
		int startIndex;
		int endIndex;
		/* Start Index not included */
		int length = endIndex - startIndex;

		public Pair(int sI, int eI) {
			this.startIndex = sI;
			this.endIndex = eI;
			this.length = eI - sI;
		}

		public void setendIndex(int eI) {
			this.endIndex = eI;
			this.length = endIndex - startIndex;
		}

		public void setstartIndex(int sI) {
			this.startIndex = sI;
			this.length = endIndex - startIndex;
		}

	}

	/*
	 * Returns res[], res[i] : (sum till index i) % k
	 */
	public static int[] prefixSumMod(int[] arr, int k) {
		int[] res = new int[arr.length];

		res[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res[i] = res[i - 1] + arr[i];
		}
		// System.out.println("Sum array: " + Arrays.toString(res));

		for (int i = 0; i < arr.length; i++) {
			res[i] = res[i] % k;
		}

		return res;
	}

	public static int[] maxLenSubarrayDivisibleByK(int[] arr, int k) {

		int[] modSumPrefix = prefixSumMod(arr, k);
		// System.out.println("Modulus array" + Arrays.toString(modSumPrefix));

		/*
		 * Stores pairs with modulus 0 to k-1 longest will be max span of
		 * modulus zero. Note : Max span can be when modulus are equal i.e
		 * exclude the previous same mod sum
		 */
		Map<Integer, Pair> modMap = new HashMap<Integer, Pair>();
		/*
		 * Note if zero found then we can start from beginning so put -1 as sI
		 * against zero as we include area interval notation :[si+1,eI]
		 * 
		 */
//		this is wrong, as it gives len = ei-si = 0 -(-1) = 1, even when no subarray found
//		modMap.put(0, new Pair(-1, 0));   
		modMap.put(0, new Pair(-1, -1));
		for (int i = 0; i < modSumPrefix.length; i++) {

			modMap.putIfAbsent(modSumPrefix[i], new Pair(i, i));
			modMap.get(modSumPrefix[i]).setendIndex(i);
		}

		int maxLen = 0;
		int sI = 0;
		int eI = 0;
		// System.out.println("Modulus sI, eI length");

		for (Map.Entry<Integer, Pair> ee : modMap.entrySet()) {

			// System.out.println(ee.getKey() + " " +
			// ee.getValue().startIndex + " " + ee.getValue().endIndex + " "
			// + ee.getValue().length);
			if (ee.getValue().length > maxLen) {
				maxLen = ee.getValue().length;
				sI = ee.getValue().startIndex;
				eI = ee.getValue().endIndex;
			}
		}
		int[] res = new int[3];
		res[0] = sI;
		res[1] = eI;
		res[2] = maxLen;
		return res;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();

		while (test-- > 0) {

			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			// res[0]--sI
			// res[1]--eI
			//res[2]--maxLen
			int[] res = maxLenSubarrayDivisibleByK(arr, k);
			System.out.println(res[2]);
		}
	}

}
