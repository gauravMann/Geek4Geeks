package treesBTAndGT.binaryTree;
import java.util.HashMap;
import java.util.Scanner;

public class CloneBinaryTreeWithRandomPointers_1 {
	private static class Tree {
		int data;
		Tree left;
		Tree right;
		Tree random;

		Tree(int data, Tree left, Tree right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Tree node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + "[R:" + node.random.data + "] <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int size = 0;
		HashMap<Integer, Tree> randomMap = new HashMap<>();

		Tree[] nodes = new Tree[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				size++;
				nodes[i] = new Tree(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}

				randomMap.put(nodes[i].data, nodes[i]);
			}
		}

		for (int i = 0; i < size; i++) {
			int from = scn.nextInt();
			int to = scn.nextInt();
			randomMap.get(from).random = randomMap.get(to);
		}

		Tree cloneRoot = clone(nodes[0]);
		display(cloneRoot);
	}

	private static Tree clone(Tree root) {
		
		// created copies of nodes between themselves and their left children
		createCloneNodesInTheTree(root);
		
		// using the structure, traversed and set randoms for clones
		setRandomsInClone(root);
		
		// cleaned the tree back, removed and collected cloned nodes.
		return clearOriginalTree(root);
	}

	private static void createCloneNodesInTheTree(Tree node) {
		if(node == null) {
			return ;
		}
		
		createCloneNodesInTheTree(node.left);
		createCloneNodesInTheTree(node.right);
		
		Tree copyNode = new Tree(node.data,node.left, null);
		node.left = copyNode;		
		
	}

	// traversing on orignial nodes
	private static void setRandomsInClone(Tree self) {
		
		if(self == null) {
			return;
		}
		
		// Nice trick, as self.random's left has a 
		// copy of itself
		if(self.random != null){
			self.left.random = self.random.left;
		}
		setRandomsInClone(self.left.left);
		setRandomsInClone(self.right);
	}

	/* Remove orignial nodes, traversing on original nodes
	* Faith
	*	left node will give root of duplicated left subtree
	* 	right tree will give root of duplicated right subtree
	*/
	
	private static Tree clearOriginalTree(Tree node) {
		if(node == null) {
			return null;
		}
		
		Tree lN = clearOriginalTree(node.left.left);
		Tree rN = clearOriginalTree(node.right);

		Tree rv = node.left;
		node.left = node.left.left;
		
		//Set left,right of node's duplicate 
		rv.left = lN;
		rv.right = rN;
		
		return rv;
	}
}
