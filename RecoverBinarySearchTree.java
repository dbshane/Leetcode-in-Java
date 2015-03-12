
public class RecoverBinarySearchTree
{
    public static void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode helper = null;
        TreeNode curr = root;
        while (curr != null)
        {
            if (curr.left == null)
            {
                if (pre != null && curr.val <= pre.val)
                {
                    if (first == null)
                        first = pre;
                    second = curr;
                }
                pre = curr;
                curr = curr.right;
            }
            else
            {
                helper = curr.left;
                while (helper.right != null && helper.right != curr)
                    helper = helper.right;
                if (helper.right == null)
                {
                    helper.right = curr;
                    curr = curr.left;
                }
                else 
                {
                    helper.right = null;
                    if (pre != null && curr.val <= pre.val)
                    {
                        if (first == null)
                            first = pre;
                        second = curr;
                    }
                    pre = curr;
                    curr = curr.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public static void main(String[] args)
	{
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(1);
		b.right = c;
		b.right = d;
		recoverTree(b);
		System.out.println(b.val);
	}
}
