import java.util.LinkedList;


public class MinimumDepthOfBinaryTree
{
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 1;
        queue.add(root);
        while (!queue.isEmpty())
        {
            LinkedList<TreeNode> children = new LinkedList<TreeNode>();
            for (TreeNode t: queue)
            {
                if (t.left == null && t.right == null) return count;
                if (t.left != null) children.add(t.left);
                if (t.right != null) children.add(t.right);
            }
            count++;
            queue = children;
        }
        return count;
    }
    public static void main(String[] args)
	{
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(minDepth(a));
	}
}
