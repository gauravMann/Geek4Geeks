package backtracking;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CombinatorialSum {

	public static void solve(int[] coins, int vidx, StringBuilder sb,
							 String ssf, int targetLeft) {
		
		if (targetLeft < 0) {
			return;
		}
		if (vidx == coins.length) {
			if (targetLeft == 0) {
				sb.append(("(" + ssf.trim() + ")"));
			}
			return;
		}


		solve(coins, vidx, sb, ssf + coins[vidx] + " ", targetLeft - coins[vidx]);


		solve(coins, vidx + 1, sb, ssf, targetLeft);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testCase = scn.nextInt();

		while (testCase-- > 0) {
			int n = scn.nextInt();
			
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(scn.nextInt());
			}
			int sum = scn.nextInt();
			
			int[] coins = new int[set.size()];
			Iterator<Integer> it  = set.iterator();
			int i = 0;
			while(it.hasNext()) {
				coins[i] = it.next();
				it.remove();
				i++;
			}
			
			Arrays.sort(coins);
			StringBuilder sb = new StringBuilder();
			
			solve(coins, 0,sb,"", sum);
			
			if(sb.length() == 0) {
				System.out.println("Empty");
			}else {
				System.out.println(sb);
			}
		}

	}

}
