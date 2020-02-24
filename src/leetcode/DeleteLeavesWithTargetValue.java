package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/contest/weekly-contest-172/problems/delete-leaves-with-a-given-value/
public class DeleteLeavesWithTargetValue {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

	}

	public static void main(String args[]) {
		DeleteLeavesWithTargetValue obj = new DeleteLeavesWithTargetValue();
//		Integer root[] = { 1, 2, 3, 2, null, 2, 4 };
		Integer root[] = {1,2,3};
		TreeNode source = obj.createTree(root, 0);
//		int target = 2;
		int target = 1;
		obj.printLevelOrder(source);
		TreeNode finalSource = obj.removeLeafNodes(source, target);
		System.out.println("***");
		obj.printLevelOrder(finalSource);
	}

	public TreeNode createTree(Integer arr[], int i) {
		if ((i) >= arr.length) {
			return null;
		}
		TreeNode node = null;
		if (arr[i] != null) {
			node = new TreeNode(arr[i]);
			node.left = createTree(arr, 2 * i + 1);
			node.right = createTree(arr, 2 * i + 2);
		}
		return node;
	}

	public void printLevelOrder(TreeNode t) {
		if (t==null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(t);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (util(root, target))
			return null;
		return root;
	}

	public boolean util(TreeNode root, int target) {
		if (root == null)
			return true;

		boolean t1 = true, t2 = true;

		if (root.left != null) {
			if (util(root.left, target)) {
				t1 = true;
				root.left = null;
			} else {
				t1 = false;
			}
		}

		if (root.right != null) {
			if (util(root.right, target)) {
				t2 = true;
				root.right = null;
			} else {
				t2 = false;
			}
		}

		if (root.val == target && (t1 && t2)) {
			return true;
		}
		return false;
	}

}
