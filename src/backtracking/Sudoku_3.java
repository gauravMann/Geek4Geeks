package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku_3 {

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

	public static void setMasks(int[][]grid,int[]rowMask,int[]colMask,int[][]sectorMask) {
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] != 0) {
					int mask = 1 << grid[i][j];
					int sectorX = i/3;
					int sectorY = j / 3;
					rowMask[i] |= mask;
					colMask[j] |= mask;
					sectorMask[sectorX][sectorY] |= mask;
				}
			}
		}
		
	}
	
	
	public static boolean solveSudoku(int[][] grid, int i, int j,
			int[]rowMask,int[]colMask,int[][]sectorMask) {
		/*
		 * arr[0]: i , arr[1] : j of next empty cell. if no empty cell
		 * found(-1,-1) means puzzle solved
		 */
		int[] nextCell = nextCellToFill(grid);
		if (nextCell[0] == -1) {
			return true;
		}
		int rI = nextCell[0];
		int cI = nextCell[1];
		
		for (int num = 1; num <= 9; num++) {
			int mask = 1 << num;
			int sectorX = rI/3;
			int sectorY = cI / 3;
			
			if ((rowMask[rI]&mask) != mask 
				&& (colMask[cI]&mask) != mask 
				&& (sectorMask[sectorX][sectorY]&mask) != mask
				) {
				
				// set
				grid[rI][cI] = num;
				rowMask[rI] |= mask;
				colMask[cI] |= mask;
				sectorMask[sectorX][sectorY] |= mask;

				if (solveSudoku(grid, rI, cI,rowMask,colMask,sectorMask)) {
					return true;
				}
				
				// unset
				grid[rI][cI] = 0;
				rowMask[rI] &= ~(mask);
				colMask[cI] &= ~(mask);
				sectorMask[sectorX][sectorY] &= ~(mask);
				
			}
		}
		return false;
	}

	public static void printSudoku(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		
		while(test-- > 0) {
			int[][] grid = new int[9][9];
			
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					grid[i][j] = scn.nextInt();
				}

			}
			
			int[]rowMask = new int[9];
			int[]colMask = new int[9];
			int sectorMask[][] = new int[3][3];
			setMasks(grid, rowMask, colMask, sectorMask);
			
			boolean solvable = solveSudoku(grid, 0, 0, rowMask, colMask, sectorMask);
			printSudoku(grid);
			System.out.println();

		}
		
	}

}
