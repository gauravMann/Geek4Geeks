package strings;

import java.util.ArrayList;
import java.util.Scanner;
/*https://www.geeksforgeeks.org/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/
 * */

public class FormAllSentences_53 {

	public static ArrayList<String> printAllSentences(String[][] list, String ansf, int vidx) {

		if (vidx == list.length) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}

		ArrayList<String> result = printAllSentences(list, ansf, vidx + 1);
		ArrayList<String> myres = new ArrayList<String>();

		for (int i = 0; i < list[vidx].length; i++) {
			for (String s : result) {
				myres.add(list[vidx][i] + " " + s);
			}
		}

		return myres;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int row = scn.nextInt();
		int col = scn.nextInt();

		String arr[][] = new String[row][col];
		for (int i = 0; i < arr.length; i++) {
			int noofcolineachrow = scn.nextInt();
			for (int j = 0; j < noofcolineachrow; j++) {
				arr[i][j] = scn.next();
			}
		}

		for (String s : printAllSentences(arr, "", 0)) {
			System.out.println(s);
		}

	}

}
