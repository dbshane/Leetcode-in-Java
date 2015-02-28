import java.util.*;

/*Given an array of integers, find two numbers such that they add up to a specific target number.

*The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

*You may assume that each input would have exactly one solution.

*Input: numbers={2, 7, 11, 15}, target=9
*Output: index1=1, index2=2 */

public class TwoSum
{
	public int[] twoSum(int[] numbers, int target) 
	{
		int N = numbers.length;
		Hashtable<Integer, Integer> set = new Hashtable<Integer, Integer>();
		int index1 = 0;
		int index2 = 0;
        for (int i = 0; i < N; i++)
        {
        	int diff = target - numbers[i];
        	set.put(diff, i);
        }
        for (int i = 0; i < N; i++)
        {
        	/*making sure the number doesn't have the same index 
        	* (e.g., if there is only one "2", and the target is "4", we don't want to use "2" two times*/
        	if (set.containsKey(numbers[i]) && i != set.get(numbers[i]))
        	{
        		index1 = i + 1;
        		index2 = set.get(numbers[i]) + 1;
        		break;
        	}
        }
        if(index1 > index2) 
        {
        	int swap = index2;
        	index2 = index1;
        	index1 = swap;
        }
        int[] a = {index1, index2};
        return a;
    }
	public static void main(String[] args)
	{
		int[] numbers = {0,4,3,0};
		TwoSum sum = new TwoSum();
		int[] a = sum.twoSum(numbers, 0);
		System.out.println(a[0] + " " + a[1]);
	}
}
