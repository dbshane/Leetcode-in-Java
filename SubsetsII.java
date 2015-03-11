import java.util.ArrayList;
import java.util.Arrays;


public class SubsetsII
{
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        subsets(num, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void subsets(int[] num, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res)
    {
        res.add(new ArrayList<Integer>(temp));
        for (int i = start; i < num.length; i++)
        {
            temp.add(num[i]);
            subsets(num, i+1, temp, res);
            temp.remove(temp.size()-1);
            while (i < num.length-1 && num[i+1] == num[i])
            	i++;
        }
    }
    
    public static void main(String[] args)
	{
		int[] a = {1,1,2,4};
		System.out.println(subsetsWithDup(a));
	}
    
}
