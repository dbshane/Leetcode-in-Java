import java.util.Stack;


public class BSTIterator
{
    private Stack<TreeNode> stack;
    private TreeNode curr;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
    }

    /** @return the next smallest number */
    public int next() {
        if (curr != null)
        {
        	stack.push(curr);
            curr = curr.left;
            return next();
        }
        else
        {
            TreeNode temp = stack.pop();
            curr = temp.right;
            return temp.val;
        }
    }
    
    public static void main(String[] args)
	{
    	TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.right = d;
		c.right = e;
		BSTIterator iterator = new BSTIterator(a);
		System.out.println(iterator.hasNext() + " " + iterator.next());
		System.out.println(iterator.hasNext() + " " + iterator.next());
		System.out.println(iterator.hasNext() + " " + iterator.next());
		System.out.println(iterator.hasNext() + " " + iterator.next());
		System.out.println(iterator.hasNext() + " " + iterator.next());
		System.out.println(iterator.hasNext());
	}
}
