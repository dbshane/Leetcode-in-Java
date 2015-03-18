import java.util.HashMap;


public class LongestConsecutiveSequence
{
    public static int longestConsecutive(int[] num) {
        HashMap<Integer, int[]> a = new HashMap<Integer, int[]>();
        int max = 0;
        for (int i = 0; i < num.length; i++)
            a.put(num[i], new int[]{1});
        for (int i = 0; i < num.length; i++)
        {
            if (a.containsKey(num[i]+1))
                union(num[i], num[i]+1, a);
            if (a.containsKey(num[i]-1))
                union(num[i], num[i]-1, a);
            if (a.get(num[i])[0] >  max)
            	max = a.get(num[i])[0];
        }
        for (int i = 0; i < num.length; i++)
        	System.out.println(a.get(num[i])[0]);
        return max;
    }
    
    private static int union(int p, int q, HashMap<Integer, int[]> a)
    {
        a.get(q)[0] += a.get(p)[0];
        a.get(p)[0] = a.get(q)[0];
        a.put(p, a.get(q));
        return a.get(q)[0];
    }
    
    public static void main(String[] args)
	{
		longestConsecutive(new int[]{100,4,200,1,3,2});
	}
}
