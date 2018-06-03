package backtracking;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CombinatorialSum {

	public static void printPath(int[] coins, int src, int sum, StringBuilder sb, int called) {
		if (src == sum) {
			System.out.print("(");
			for (int i = 0; i < sb.length(); i++) {
				System.out.print(sb.charAt(i) + " ");
			}
			System.out.print(")");
			return;
		}

		for (int denom = called; denom < coins.length; denom++) {
			int inter = src + coins[denom];
			if (inter <= sum) {
				sb.append(coins[denom]);

				printPath(coins, inter, sum, sb, denom);
				sb.deleteCharAt(sb.length() - 1);

			}
		}

	}

	public static void solve(int[] coins, int vidx, StringBuilder sb, int sum) {
		if(sum < 0){
			return;
		}
		if (vidx == coins.length) {
			if (sum == 0) {
				System.out.print("(" + sb + ")");
			}
			return;
		}
		
		solve(coins, vidx, sb.append(coins[vidx]), sum - coins[vidx]);
		sb.deleteCharAt(sb.length() - 1);
		solve(coins, vidx + 1, sb, sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int testCase = scn.nextInt();

		while (testCase-- > 0) {
			int n = scn.nextInt();
			int[] coins = new int[n];

			for (int i = 0; i < n; i++) {
				coins[i] = scn.nextInt();
			}
			Arrays.sort(coins);
			int sum = scn.nextInt();
			scn.close();

			solve(coins, 0, new StringBuilder(""),  sum);
			//printPath(coins, 0, sum, new StringBuilder(""), 0);
			System.out.println();
		}

	}

}
