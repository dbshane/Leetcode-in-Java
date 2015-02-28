import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSumII
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        search(num, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void search(int[] num, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result)
    {
        if (target < 0) return;
        if (target == 0)
        {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i < num.length; i++)
        {
            temp.add(num[i]);
            search(num, i+1, target-num[i], temp, result);
            temp.remove(temp.size()-1);
            while (i < num.length-1 && num[i] == num[i+1]) i++;   // prevent repetition, like 1 1 1, if skipped the first "1", second or third "1" can't be used
        }
    }
    public static void main(String[] args)
	{
    	int[] candidates = {1,1};
		System.out.println(combinationSum2(candidates,2));
	}
}
