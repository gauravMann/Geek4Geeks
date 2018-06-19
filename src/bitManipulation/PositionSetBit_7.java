package bitManipulation;

import java.util.Scanner;

public class PositionSetBit_7 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test-- > 0) {
			
			int num = scn.nextInt();

			double pow = Math.log(num) / Math.log(2);
			int p = (int) (Math.log(num) / Math.log(2));
			if (Math.ceil(pow) == p) {
				System.out.println(p + 1);
			} else {
				System.out.println("-1");
			}
		}
	}
}
