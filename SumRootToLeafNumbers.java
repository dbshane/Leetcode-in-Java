
public class SumRootToLeafNumbers
{
    public static int sumNumbers(TreeNode root) {
        int[] total = new int[]{0};
        helper(root, new StringBuilder(), total);
        return total[0];
    }
    
    private static void helper(TreeNode root, StringBuilder sb, int[] total)
    {
        if (root == null) return;
        sb.append((char) (root.val+'0'));
        if (root.left == null && root.right == null) 
        {
        	total[0] += Integer.parseInt(sb.toString());
        	sb.deleteCharAt(sb.length()-1);
        	return;
        }
        else
        {
        	helper(root.left, sb, total);
        	helper(root.right, sb, total);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args)
	{
		TreeNode a = new TreeNode(0);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(2);
		a.left = b;
		a.right = c;
		System.out.println(sumNumbers(a));
	}
}
