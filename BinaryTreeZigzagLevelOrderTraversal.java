import java.util.ArrayList;


public class BinaryTreeZigzagLevelOrderTraversal
{
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        boolean reverse = true;
        while (!list.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            ArrayList<TreeNode> children = new ArrayList<TreeNode>();
            for (TreeNode node: list)
            {
                if (node != null)
                {
                    temp.add(node.val);
                    if (reverse)
                    {
                        children.add(node.left);
                        children.add(node.right);
                    }
                    else
                    {
                        children.add(node.right);
                        children.add(node.left);
                    }
                }
            }
            if (!temp.isEmpty()) res.add(temp);
            ArrayList<TreeNode> r = new ArrayList<TreeNode>();
            for (int i = children.size()-1; i >= 0; i--)
                r.add(children.get(i));
            reverse = !reverse;
            list = r;
        }
        return res;
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
		System.out.println(zigzagLevelOrder(a));
	}

}
