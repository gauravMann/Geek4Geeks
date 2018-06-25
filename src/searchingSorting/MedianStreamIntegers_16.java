package searchingSorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianStreamIntegers_16 {

	public static void solve(int[] arr) {
		// simulates small half of sorted array
		PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minH = new PriorityQueue<>();
		int median = 0;

		for (int i = 0; i < arr.length; i++) {
			int sz_diff = maxH.size() - minH.size();

			switch (sz_diff) {
			// heaps balanced,after addition one becomes larger in size by 1
			// median is given by bigger heap
			case 0:
				if (arr[i] < median) {
					maxH.add(arr[i]);
					median = maxH.peek();
				} else {
					minH.add(arr[i]);
					median = minH.peek();
				}
				break;
			// left heap has more elements, after addition both have same size
			// by question demand, even length median is smaller of two
			case 1:
				if (arr[i] < median) {
					minH.add(maxH.remove());
					maxH.add(arr[i]);
				} else {
					minH.add(arr[i]);
				}
				median = (maxH.peek()+ minH.peek())/2;
				
				break;
			// right heap has more elements
			case -1:
				if (arr[i] < median) {
					maxH.add(arr[i]);
				} else {
					maxH.add(minH.remove());
					minH.add(arr[i]);
				}
				median = (maxH.peek()+ minH.peek())/2;
				break;

			default:
				System.out.println("Entered in default");
				break;
			}
			System.out.println(median);
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
			solve(arr);
		}
	}

}
