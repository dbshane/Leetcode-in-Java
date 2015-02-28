import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum
{
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        search(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    private static void search(int[] candidates, int i, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result)
    {
        if (target < 0) return;
        if (target == 0)
        {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int j = i; j < candidates.length; j++)
        {
        	if (j > 0 && candidates[j] == candidates[j-1]) continue;
            temp.add(candidates[j]);
            search(candidates, j, target-candidates[j], temp, result);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args)
	{
    	int[] candidates = {2,2,3,6,7};
		System.out.println(combinationSum(candidates,7));
	}
}
