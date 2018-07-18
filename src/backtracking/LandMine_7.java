package backtracking;

import java.util.Scanner;

public class LandMine_7 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };

	public static int solve(int[][] grid, int r, int c, boolean[][] visited, int count) {

		if (c == grid[0].length - 1) {
			return count;
		}

		if (isInvalid(grid, r, c, visited)) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;

		visited[r][c] = true;
		for (int i = 0; i < dir.length; i++) {
			int rdash = r + dir[i][0];
			int cdash = c + dir[i][1];
			min = Math.min(min, solve(grid, rdash, cdash, visited, count + 1));
		}
		visited[r][c] = false;

		return min;
	}

	public static void rowCalls(int[][] grid, boolean[][] visited) {

		fixGrid(grid, visited);

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < grid.length; i++) {
			min = Math.min(min, solve(grid, i, 0, visited, 0));
		}
		System.out.println(min);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();

		int[][] grid = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = scn.nextInt();
			}
		}

		scn.close();

		rowCalls(grid, visited);
	}

	/* Set ones adjacent to zeroes as 2 */
	public static void fixGrid(int[][] grid, boolean[][] visited) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 0) {

					for (int d = 0; d < dir.length; d++) {
						int rdash = i + dir[d][0];
						int cdash = j + dir[d][1];
						if (!isInvalid(grid, rdash, cdash)) {
							grid[rdash][cdash] = 2;
						}
					}
				}
			}
		}
	}

	public static boolean isInvalid(int grid[][], int r, int c, boolean[][] visited) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 2 || grid[r][c] == 0
				|| visited[r][c] == true) {
			return true;
		}
		return false;
	}

	public static boolean isInvalid(int grid[][], int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
			return true;
		}
		return false;
	}

}
