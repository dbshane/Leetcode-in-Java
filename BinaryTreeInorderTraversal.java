import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreeInorderTraversal
{
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null)
        {
            if (curr!= null)  //left side of current node
            {
                stack.push(curr);
                curr = curr.left;
            }
            else //since the left side is null, pop the stack and handle the right side
            {
                TreeNode p = stack.pop();
                res.add(p.val);
                curr = p.right;
            }
        }
        return res;
    }
    public static void main(String[] args)
	{
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(2);
		a.left = b;
		a.right = c;
		b.left = d;
		d.right = e;
		System.out.println(inorderTraversal(a));
	}
}
