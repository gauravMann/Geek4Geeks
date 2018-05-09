package backtracking;

public class KnightTour {

	public static boolean isTourComplete(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == false) {
					return false;
				}
			}
		}

		return true;
	}

	static int[][] directions = { { -2, 1 }, // north
			{ -2, -1 }, // nE
			{ -1, 2 }, // east
			{ -1, -2 }, // se
			{ 1, 2 }, // s
			{ 1, -2 }, // sw
			{ 2, -1 }, // w
			{ 2, 1 },// nw
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
