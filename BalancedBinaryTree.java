
public class BalancedBinaryTree
{
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(nodeDepth(root.left)-nodeDepth(root.right)) > 1)
        	return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private static int nodeDepth(TreeNode root)
    {
    	if (root == null) return 0;
    	return Math.max(nodeDepth(root.left), nodeDepth(root.right))+1;
    }
    
    public static void main(String[] args)
	{
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(7);
		a.left = b;
		a.right = c;
		c.left = d;
		c.right = e;
		System.out.println(isBalanced(a));
	}
}
