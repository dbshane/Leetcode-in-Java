import java.util.ArrayList;

public class PascalsTriangle
{
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return res;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; i++)
        {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            ArrayList<Integer> pre = res.get(res.size()-1);
            curr.add(1);
            for (int j = 0; j < pre.size()-1; j++)
                curr.add(pre.get(j)+pre.get(j+1));
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
    public static void main(String[] args)
	{
		System.out.println(generate(7));
	}
}