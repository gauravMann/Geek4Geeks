package backtracking;

import java.util.Scanner;

public class KnightTour_1 {
	static int[][] directions = { { -2, 1 },{ -2, -1 }, 
								  { -1, 2 },{ -1, -2 },
								  { 1, 2  },{ 1, -2  },
								  { 2, -1 },{ 2, 1  },
								};

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int srow = scn.nextInt();
		int scol = scn.nextInt();
		System.out.println(knightTour(srow, scol, new Integer[n][n], 0));
		scn.close();
	}

	private static boolean knightTour(int sr, int sc, Integer[][] visited, int moves) {

		if (moves == visited.length * visited.length) {
			return true;
		}

		if (isInvalid(sr, sc, visited)) {
			return false;
		}
		
		visited[sr][sc] = moves;
		
		for (int i = 0; i < directions.length; i++) {
			int xdash = sr + directions[i][0];
			int ydash = sc + directions[i][1];
			if (knightTour(xdash, ydash, visited, moves + 1)) {
				return true;
			}
		}
		visited[sr][sc] = null;
		return false;
	}

	private static boolean isInvalid(int sr, int sc, Integer[][] visited) {
		if (sr < 0 || sr >= visited.length || sc < 0 || sc >= visited[0].length
				|| visited[sr][sc] != null) {
			return true;
		}
		return false;
	}

}
