
public class MaximumDepthOfBinaryTree
{
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
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
		b.left = d;
		c.right = e;
		System.out.println(maxDepth(a));
	}
}
