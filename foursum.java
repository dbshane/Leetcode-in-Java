import java.util.*;
public class foursum
{
    public static List<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length; i++)
        {
            if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < num.length; j++)
            {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                twoSum(result, num, j + 1, target - num[i] - num[j], i, j);
            }
        }
        return result;
    }
    
    private static void twoSum(ArrayList<ArrayList<Integer>> result, int[] num, int pointer, int sum, int i, int j)
    {
        HashSet<Integer> record = new HashSet<Integer>();
        int l = pointer;
        int r = num.length - 1;
        while (l < r)
        {
            if (num[l] + num[r] == sum && !record.contains(num[l]))
            {
                record.add(num[l]);
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.add(num[i]);
                set.add(num[j]);
                set.add(num[l]);
                set.add(num[r]);
                result.add(set);
            }
            if (num[l] + num[r] < sum) l++;
            else r--;
        }
    }
    public static void main(String[] args)
	{
    	int[] a = {1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(a, 0));
	}
}
