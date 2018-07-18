package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class RatInMaze_2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		while (test-- > 0) {
			int n = scn.nextInt();

			int[][] maze = new int[n][n];

			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					maze[i][j] = scn.nextInt();
				}
			}
			solve(maze);
		}
	}

	private static void solve(int[][] maze) {
		ArrayList<String> paths = new ArrayList<>();
		ratMaze(0, 0, maze, new int[maze.length][maze[0].length], paths, "");
//		System.out.println(paths);
		
	}

	private static void ratMaze(int sr, int sc, int[][] maze, int[][] visited, ArrayList<String> paths, String psf) {

		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			paths.add(psf);
//			System.out.println(psf);
			return;
		}

		if (isInvalid(sr, sc, maze, visited)) {
			return;
		}
		
		visited[sr][sc] = 1;
		ratMaze(sr + 1, sc, maze, visited, paths, psf + "D");
		ratMaze(sr, sc - 1, maze, visited, paths, psf + "L");
		ratMaze(sr, sc + 1, maze, visited, paths, psf + "R");
		ratMaze(sr - 1, sc, maze, visited, paths, psf + "U");
		visited[sr][sc] = 0;
	}

	private static boolean isInvalid(int sr, int sc, int[][] maze, int[][] visited) {
		if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length
				|| maze[sr][sc] == 0 || visited[sr][sc] == 1) {
			return true;
		}
		return false;
			
	}

}
