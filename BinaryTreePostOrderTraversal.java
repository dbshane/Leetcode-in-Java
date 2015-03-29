import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;


public class BinaryTreePostOrderTraversal
{
	// Use a hashset to record those treenodes whose right leaf have been visited
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            if (curr == null)
            {
                if (!set.contains(stack.peek()))
                {
                	set.add(stack.peek());
                	curr = stack.peek().right;
                } 
                else 
                {
                    TreeNode temp = stack.pop();
                    res.add(temp.val);
                }
            }
            else
            {
                stack.push(curr);
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
		System.out.println(postorderTraversal(a));
	}
}
