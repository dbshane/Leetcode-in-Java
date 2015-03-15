
public class FlattenBinaryTreeToLinkedList
{
    public static void flatten(TreeNode root) {
    	if (root == null) return;
    	helper(root);
    }
    
    private static TreeNode helper(TreeNode root)
    {
        if (root.left == null && root.right == null) return root;
        else if (root.left != null)
        {
        	TreeNode pre = helper(root.left);
        	TreeNode temp = root.right;
       		root.right = root.left;
       		root.left = null;
       		pre.right = temp;
       		if (pre.right == null) return pre;
       		else
       			return helper(pre.right);
       	}
        else return helper(root.right);
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
		d.right = e;
		flatten(a);
		System.out.println((a.val));
		System.out.println((a.right.val));
		System.out.println((a.right.right.val));
		System.out.println((a.right.right.right.val));
	}

}
