
public class ValidateBinarySearchTree
{
    public static boolean isValidBST(TreeNode root) {
    	return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isValidBST(TreeNode root, int lo, int hi)
    {
        if (root == null) return true;
        if ((root.left != null && (root.left.val >= root.val || root.left.val < lo)) 
        	|| (root.right != null && (root.right.val <= root.val || root.right.val > hi)))
        	return false;
        return isValidBST(root.left, lo, root.val-1) && isValidBST(root.right, root.val+1, hi);
    }
    public static void main(String[] args)
	{
    	TreeNode a = new TreeNode(-2147483648);
		TreeNode c = new TreeNode(2147483647);
		TreeNode d = new TreeNode(-2147483647);
		a.right = c;
		c.left = d;
		System.out.println(isValidBST(a));
	}
		
}
