import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreePostOrderTraversalII
{
	// No use of Hashset
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (root == null) return res;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	TreeNode pre = root; // set pre to root to start to make sure safe; setting to null is wrong
    	while (!stack.isEmpty())
    	{
    		TreeNode temp = stack.peek();
    		if ((temp.left == null && temp.right == null)
    			|| (temp.left == pre || temp.right == pre))
    		{
    			stack.pop();
    			res.add(temp.val);
    			pre = temp;
    		}
    		else
    		{
    			if (temp.right != null)
    				stack.push(temp.right);
    			if (temp.left != null)
    				stack.push(temp.left);
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
		a.right = b;
		b.right = c;
		c.right = d;
		d.right = e;
		System.out.println(postorderTraversal(a));
	}
}
