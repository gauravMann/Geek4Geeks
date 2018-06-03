package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int bsize = scn.nextInt();
		scn.close();
		// g[i] stores column place of queen in ith row
		int[] G = new int[bsize];
		Arrays.fill(G, -1);
		placeQueen(G, 0);

	}

	private static void placeQueen(int[] G, int row) {
		if (row >= G.length) {
			printBoard(G);
			return;
		}

		for (int col = 0; col < G.length; col++) {
			G[row] = col;
			if (isSafe(G, row)) {
				placeQueen(G, row + 1);
			} else {
				G[row] = -1;
			}
		}
	}

	private static void printBoard(int[] g) {
		
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				if (g[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isSafe(int[] G, int pos) {
		for (int i = 0; i < pos; i++) {
			if (G[i] == G[pos]) {
				return false;
			}

			if (Math.abs(G[i] - G[pos]) == Math.abs(i - pos)) {

				return false;
			}
		}

		return true;
	}
}
