package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MergingIntervals_24 {

	public static class Pair implements Comparable<Pair> {
		int start;
		int end;

		public Pair(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Pair o) {
			return this.start - o.start;
		}
	}

	
	public static void mergeIntervals(Pair[] intervals) {
		Arrays.sort(intervals);

		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i].start <= intervals[i - 1].end) {
				intervals[i].start = intervals[i - 1].start;
				intervals[i].end = Math.max(intervals[i - 1].end, intervals[i].end);
				intervals[i - 1].start = -1;
				intervals[i - 1].end = -1;
			}
		}
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i].start != -1 && intervals[i].end != -1) {
				System.out.print(intervals[i].start + " " + intervals[i].end + " ");
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();
		while (test-- > 0) {

			int n = scn.nextInt();

			Pair[] intervals = new Pair[n];

			for (int i = 0; i < intervals.length; i++) {
				intervals[i] = new Pair(scn.nextInt(), scn.nextInt());
			}

			mergeIntervals(intervals);
			System.out.println();
		}
	}
}
