package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
	public static int backtracks = 0;

	public static int[] nextCellToFill(int[][] grid) {
		int[] pos = new int[2];
		Arrays.fill(pos, -1);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					pos[0] = i;
					pos[1] = j;
					return pos;
				}
			}
		}
		return pos;
	}

	public static boolean checkRow(int[][] grid, int i, int j, int key) {

		/*
		 * Check if ALL elements are different from key in row i. Thus iteration
		 * done over columns.
		 */
		for (int scanCol = 0; scanCol < grid[0].length; scanCol++) {
			if (grid[i][scanCol] == key) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkCol(int[][] grid, int i, int j, int key) {

		/*
		 * Check if elements are different from key in column j. Thus iteration
		 * done over rows
		 */
		for (int scanRow = 0; scanRow < grid.length; scanRow++) {
			if (grid[scanRow][j] == key) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkSector(int[][] grid, int i, int j, int key) {

		/* Starting cell of sector Sector : 3 X 3 matrix */
		int sectorX = 3 * (i / 3);
		int sectorY = 3 * (j / 3);

		for (int sRow = sectorX; sRow < sectorX + 3; sRow++) {
			for (int sCol = sectorY; sCol < sectorY + 3; sCol++) {

				if (grid[sRow][sCol] == key) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(int[][] grid, int i, int j, int key) {

		if (checkRow(grid, i, j, key)) {

			if (checkCol(grid, i, j, key)) {

				if (checkSector(grid, i, j, key)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean solveSudoku(int[][] grid, int i, int j) {
		/*
		 * arr[0]: i , arr[1] : j of next empty cell. if no empty cell
		 * found(-1,-1) means puzzle solved
		 */
		int[] nextCell = nextCellToFill(grid);
		if (nextCell[0] == -1) {
			return true;
		}
		for (int num = 1; num <= 9; num++) {
			if (isValid(grid, nextCell[0], nextCell[1], num)) {
				grid[nextCell[0]][nextCell[1]] = num;

				if (solveSudoku(grid, nextCell[0], nextCell[1])) {
					return true;
				}
				// backTrack
				backtracks += 1;
				grid[nextCell[0]][nextCell[1]] = 0;
			}
		}
		return false;
	}

	public static void printSudoku(int[][] grid) {
		/* print sectors differently */
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int[][] grid = new int[9][9];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = scn.nextInt();
			}

		}

//		System.out.println(solveSudoku(grid, 0, 0)+ "  "+ backtracks );
		boolean solvable = solveSudoku(grid, 0, 0);
		printSudoku(grid);
		System.out.println(solvable+" "+ backtracks);
		scn.close();

	}

}
