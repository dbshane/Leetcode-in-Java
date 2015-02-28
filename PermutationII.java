import java.util.ArrayList;
import java.util.Arrays;


public class PermutationII
{
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num.length == 0) return null;
        Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		boolean[] used = new boolean[num.length];
		ArrayList<Integer> build = new ArrayList<Integer>();
		permuteUnique(num, used, build, res);
		return res;
    }
    
    private static void permuteUnique(int[] num, boolean[] used, ArrayList<Integer> build, ArrayList<ArrayList<Integer>> res)
    {
        if (build.size() == num.length) res.add(new ArrayList<Integer>(build));
        for (int i = 0; i < num.length; i++)
        {
            if (i > 0 && !used[i-1] && num[i] == num[i-1])  continue;   //prevent repetition 
            if (used[i] == false)
            {
                build.add(num[i]);
                used[i] = true;
                permuteUnique(num, used, build, res);
                used[i] = false;
                build.remove(build.size()-1);
            }
        }
    }
	public static void main(String[] args)
	{
		int[] a = {1,1,1,3};
		System.out.println(permuteUnique(a));
	}
}
