
import java.util.HashSet;


public class BinaryTreeMaximumPathSum
{
    public static int maxPathSum(TreeNode root) {
        HashSet<Integer> set = new HashSet<Integer>();
        maxPathSum(root, set);
        int max = Integer.MIN_VALUE;
        for (int i: set)
            if (i > max) max = i;
        return max;
    }
    
    private static int maxPathSum(TreeNode root, HashSet<Integer> list)
    {
        if (root == null) return 0;
        int maxleft = maxPathSum(root.left, list);
        int maxright = maxPathSum(root.right, list);
        int sum = root.val;
        if (maxleft > 0) sum += maxleft;
        if (maxright > 0) sum += maxright;
        list.add(sum);
        return Math.max(Math.max(maxleft + root.val, maxright + root.val), root.val);
    }
	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(-1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(maxPathSum(a));
	}
}
