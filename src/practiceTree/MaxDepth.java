package practiceTree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {
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

	TreeNode root;
	int maxFalg = 0;

	public static void main(String args[]) {
		MaxDepth obj = new MaxDepth();
		int tree[] = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
		TreeNode root = obj.buildTree(tree, 0, 0);
		System.out.println(obj.maxDepth(root));
		// System.out.println(obj.maxDepth(obj.root));

	}

	public TreeNode buildTree(int tree[], int i, int flag) {
		if (tree[i] == Integer.MIN_VALUE)
			return null;
		TreeNode temp = new TreeNode(tree[i]);
		if (2 * i + 1 < tree.length) {
			temp.left = buildTree(tree, 2 * i + 1, flag);
			temp.right = buildTree(tree, 2 * i + 2, flag);
		}
		return temp;
	}

	public int maxDepth(TreeNode root) {
		if (root==null) 
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
}
