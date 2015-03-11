import java.util.ArrayList;

public class UniqueBinarySearchTreesII
{
    public static ArrayList<TreeNode> generateTrees(int n) {
        return helper(1,n);
        
    }
    
    private static ArrayList<TreeNode> helper(int lo, int hi)
    {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (hi < lo)
        {
            res.add(null);
            return res;
        }
        for (int i = lo; i <= hi; i++)
        {
            ArrayList<TreeNode> left = helper(lo, i-1);
            ArrayList<TreeNode> right = helper(i+1, hi);
            for (TreeNode j: left)
            {
                for (TreeNode k: right)
                {
                    TreeNode temp = new TreeNode(i);
                    temp.left = j;
                    temp.right = k;
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
