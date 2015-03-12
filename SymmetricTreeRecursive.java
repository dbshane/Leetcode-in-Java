
public class SymmetricTreeRecursive
{
    public static boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    //using recursive in-order traversal to iterate the tree
    private static boolean helper(TreeNode l, TreeNode r)
    {
        if ((l == null || r == null) && l != r) return false;
        if (l == null) return true;
        if (!helper(l.left, r.right)) return false;
        if (l == r) return true;  // the only case that l == r is that l and r are both root, skip the other half
        if (l.val != r.val) return false;
        return helper(l.right, r.left);
    }
    public static void main(String[] args)
	{
        	TreeNode a = null;
    		System.out.println(isSymmetric(a));
	}
}
