
public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    private static TreeNode helper(int[] preorder, int curr, int[] inorder, int lo, int hi)
    {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(preorder[curr]);
        for (int i = lo; i <= hi; i++)
        {
            if (inorder[i] == preorder[curr])
            {
                root.left = helper(preorder, curr+1, inorder, lo, i-1);
                root.right = helper(preorder, curr+i-lo+1, inorder, i+1, hi);
            }
        }
        return root;
    }
    public static void main(String[] args)
	{
		System.out.println(buildTree(new int[]{3,5,7}, new int[]{3,5,7}).val);
	}
}
