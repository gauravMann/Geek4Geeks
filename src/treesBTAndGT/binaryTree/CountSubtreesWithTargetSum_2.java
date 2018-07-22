package treesBTAndGT.binaryTree;
import java.util.Scanner;

public class CountSubtreesWithTargetSum_2 {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Node root = null;

		Scanner scn = new Scanner(System.in);
		
		int tar = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}
		
		// display(nodes[0]);
		System.out.println(solve(nodes[0], tar).count);
	}
	
	private static class SubtreeSumCount{
		int sum = 0;
		int count = 0;
		
		SubtreeSumCount(int sum, int count){
			this.sum = sum;
			this.count = count;
		}
	}

	
	private static SubtreeSumCount solve(Node node, int tar){
		if(node == null) {
			SubtreeSumCount base = new SubtreeSumCount(0, 0); 
			return base;
		}
		 SubtreeSumCount self = new SubtreeSumCount(0, 0);
		 
		 SubtreeSumCount left = solve(node.left, tar);
		 SubtreeSumCount right = solve(node.right, tar);
		 
		 self.sum = left.sum + right.sum + node.data;
		 self.count = left.count + right.count;
		 if(self.sum == tar) {
			 self.count += 1;
		 }
		 return self;
	}
}
