
public class ConstructBinaryTreeFromInorderAndPostorderTraversal
{
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
    
    private static TreeNode helper(int[] inorder, int lo, int hi, int[] postorder, int curr)
    {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(postorder[curr]);
        for (int i = lo; i <= hi; i++)
        {
            if (inorder[i] == postorder[curr])
            {
                root.left = helper(inorder, lo, i-1, postorder, curr-(hi-i)-1); // hi-i is the number of nodes on the right side, jump over these
                root.right = helper(inorder, i+1, hi, postorder, curr-1);
            }
        }
        return root;
    }
    public static void main(String[] args)
	{
		System.out.println(buildTree(new int[]{1,2,3,4}, new int[]{1,4,3,2}).val);
	}
}
