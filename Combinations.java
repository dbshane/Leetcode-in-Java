import java.util.ArrayList;


public class Combinations
{
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (k > n || k == 0 || n == 0) return res;
        combine(n, 0, new ArrayList<Integer>(), k, res);
        return res;
    }
    private static void combine(int n, int count, ArrayList<Integer> temp, int k, ArrayList<ArrayList<Integer>> res)
    {
        if (count == k)  res.add(new ArrayList<Integer>(temp));
        int min = (temp.size()==0?0:temp.get(temp.size()-1));
        if (min > n) return;
        for (int i = min+1; i <= n;i++)
        {
            temp.add(i);
            combine(n, count+1, temp, k, res);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args)
	{
		System.out.println(combine(4,3));
	}
}
