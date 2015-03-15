
public class PathSum
{
	// this problem is asking root to leaf, not root to any node...And the value of a node can be negative...
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum - root.val == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(-2);
		TreeNode c = new TreeNode(-3);
		a.right = c;
		System.out.println(hasPathSum(a,-5));
	}
}

