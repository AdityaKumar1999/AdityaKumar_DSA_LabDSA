package Problem_2;

import java.util.*;

public class Nodes {
	public static class Node {

		int key;
		Node left, right;

		public Node(int x) {
			this.key = x;
		}
	}

	public Node insertElement(Node root, int x) {
		if (root == null) {
			return (new Node(x));
		}
		if (x < root.key)
			root.left = insertElement(root.left, x);
		else if (x > root.key)
			root.right = insertElement(root.right, x);
		else // Duplicate keys not allowed
			return root;

		return root;
	}

	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> queue1 = new LinkedList<>();

	public void inorderTraversal(Node node) {
		if (node == null)
			return;
		inorderTraversal(node.left);
		queue.add(node.key);
		queue1.add(node.key);
		inorderTraversal(node.right);

	}

	public static void main(String[] args) {
		Nodes obj = new Nodes();
		Node root = null;
		int[] arr = { 40, 20, 60, 10, 30, 50, 70 };
		for (int i : arr) {
			if (root == null) {
				root = obj.insertElement(root, i);
			} else {
				root = obj.insertElement(root, i);
			}
		}
		obj.inorderTraversal(root);

		System.out.println("please give input for required sum");
		Scanner sc = new Scanner(System.in);
		int requiredSum = sc.nextInt();

		Integer node1 = null;
		Integer node2 = null;
		if (!queue.isEmpty()) {
			for (Integer i : queue) {
				boolean bl = false;
				int sum = 0;
				for (Integer j : queue1) {
					if (i != j) {
						sum = i + j;
						if (requiredSum == sum) {
							node1 = i;
							node2 = j;
							bl = true;
							break;
						}
					}
				}
				if (bl)
					break;

			}
		}
		if (node1 != null && node2 != null) {
			System.out.println("Sum = " + requiredSum);
			System.out.println("Pair is(" + node1 + ", " + node2 + " )");
		} else {
			System.out.println("nodes are not found.");
		}
	}
}
