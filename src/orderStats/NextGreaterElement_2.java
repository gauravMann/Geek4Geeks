package orderStats;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement_2 {

	public static void printNextGreater(int[] arr) {

		/* To maintain order */
		HashMap<Integer, Integer> nextLargerMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			nextLargerMap.put(arr[i], -1);
		}

		/**/
		Stack<Integer> processing = new Stack<>();
		processing.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < processing.peek()) {
				processing.push(arr[i]);
			} else {
				while (!processing.isEmpty() && arr[i] > processing.peek()) {
					int smaller = processing.pop();
					nextLargerMap.put(smaller, arr[i]);
				}
				processing.push(arr[i]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int nextLarger = nextLargerMap.get(arr[i]);
			System.out.print(nextLarger + " ");
		}
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
			printNextGreater(arr);
		}

	}

}
