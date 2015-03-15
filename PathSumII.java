import java.util.ArrayList;


public class PathSumII
{
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        helper(root, 0, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void helper(TreeNode root, int curr, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res)
    {
        if (root == null) return;
        if (root.val + curr == sum && root.left == null && root.right == null)
        {
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        helper(root.left, root.val+curr, sum, temp, res);
        helper(root.right, root.val+curr, sum, temp, res);
        temp.remove(temp.size()-1);
    }
	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(-2);
		TreeNode c = new TreeNode(-3);
		a.right = c;
		System.out.println(pathSum(a,-5));
	}
}
