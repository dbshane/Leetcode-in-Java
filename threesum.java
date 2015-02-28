import java.util.*;

public class threesum
{
    public List<LinkedList<Integer>> threeSum(int[] num) {
    	Arrays.sort(num);
        List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < num.length; i++)
        {
        	if (i >= 1 && num[i - 1] == num[i]) continue;
            int sum = 0 - num[i];
            System.out.println(num[i]);
            twoSum(result, num,i + 1, sum);
        }
        return result;
    }
    private void twoSum(List<LinkedList<Integer>> result, int[] array, int pointer, int sum)
    {
    	Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
    	for (int i = pointer; i < array.length; i++)  map.put(sum - array[i], i);
    	for (int i = pointer; i < array.length; i++)
    	{
    		if (map.containsKey(array[i]) && map.get(array[i]) != i)
    		{
    			map.remove(array[i]);
    			map.remove(sum - array[i]);
    			LinkedList<Integer> threelist = new LinkedList<Integer>();
    			int[] three = {-sum, array[i], sum - array[i]};
    			Arrays.sort(three);
    			threelist.add(three[0]);
    			threelist.add(three[1]);
    			threelist.add(three[2]);
    			result.add(threelist);
    			continue;
    		}
    	}
    }
    public static void main(String[] args)
	{
    	threesum a = new threesum();
    	int[] num =  {-1, 0, 1, 2, -1, -4};
    	System.out.println(a.threeSum(num));
	}
}
