import java.util.*;
public class BinaryTreeTraversal2
{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
	{
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Stack<ArrayList<Integer>> reverse = new Stack<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty())
		{
			ArrayList<Integer> e = new ArrayList<Integer>();
			LinkedList<TreeNode> children = new LinkedList<TreeNode>();
			while (!nodeQueue.isEmpty())
			{
				TreeNode t = nodeQueue.poll();
				if (t != null)
				{
					e.add(t.val);
					children.add(t.left);
					children.add(t.right);
				}
			}
			if (!e.isEmpty())
				reverse.push(e);
			nodeQueue = children;
		}
		while (!reverse.isEmpty())
		{
			result.add(reverse.pop());
		}
		return result;
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
		BinaryTreeTraversal2 ae = new BinaryTreeTraversal2();
		System.out.println(ae.levelOrderBottom(a));
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x)
	{
		val = x;
	}
}
