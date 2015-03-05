import java.util.ArrayList;
import java.util.Arrays;


public class Subsets
{
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        subsets(S, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private static void subsets(int[] S, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res)
    {
        res.add(new ArrayList<Integer>(temp));
        for (int i = start; i < S.length; i++)
        {
            temp.add(S[i]);
            subsets(S, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args)
	{
		int[] S = {};
		System.out.println(subsets(S));
	}
}
