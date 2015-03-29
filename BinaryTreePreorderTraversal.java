import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreePreorderTraversal
{
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            if (curr == null)
            {
                TreeNode t = stack.pop();
                curr = t;
            }
            else
            {
                res.add(curr.val);
                if (curr.right != null)
                    stack.push(curr.right);
                curr = curr.left;
            }
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
		b.right = e;
		System.out.println(preorderTraversal(a));
	}
}
