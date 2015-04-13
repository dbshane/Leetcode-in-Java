import java.util.HashMap;


public class MajorityElement
{
    public static int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int maxInt = 0;
        for (int i: num)
        {
            int count = map.containsKey(i)?map.get(i)+1:1;
            map.put(i, count);
            if (count > max)
            {
                max = count;
                maxInt = i;
            }
        }
        return maxInt;
    }
    public static void main(String[] args)
	{
		int[] a = {1,2,3,4,2,2,1,2};
		System.out.println(majorityElement(a));
	}
}
