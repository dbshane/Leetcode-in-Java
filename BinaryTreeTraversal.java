import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTreeTraversal
{
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (!list.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            LinkedList<TreeNode> children = new LinkedList<TreeNode>();
            for (TreeNode node: list)
            {
                if (node != null)
                {
                    temp.add(node.val);
                    children.add(node.left);
                    children.add(node.right);
                }
            }
            if (temp.size() != 0)res.add(temp);
            list = children;
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
		d.right = e;
		System.out.println(levelOrder(a));
	}
}
