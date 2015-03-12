import java.util.Stack;


public class SymmetricTreeIterative
{
    public static boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
        return helper(root, new Stack<TreeNode>(), new Stack<TreeNode>());
    }
    //using non-recursive in-order traversal to iterate the tree
    private static boolean helper(TreeNode root, Stack<TreeNode> a, Stack<TreeNode> b)
    {
        TreeNode l = root;
        TreeNode r = root;
        while (a.size() == b.size() && (!a.isEmpty() || l != null))
        {
            if ((l == null && r != null) || (r == null && l != null)) return false;
            if (l != null)
            {
                a.push(l);
                l = l.left;
                b.push(r);
                r = r.right;
            } else
            {
                TreeNode temp1 = a.pop();
                TreeNode temp2 = b.pop();
                if (temp1.val != temp2.val) return false;
                if (temp1 == root && temp2 == root) return true;
                l = temp1.right;
                r = temp2.left;
            }
        }
        return false;
    }
    public static void main(String[] args)
	{
        	TreeNode a = new TreeNode(1);
    		TreeNode c = new TreeNode(2);
    		TreeNode d = new TreeNode(2);
    		a.right = c;
    		a.left = d;
    		System.out.println(isSymmetric(a));
	}
}
