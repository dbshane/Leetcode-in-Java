import java.util.Arrays;


public class ThreeSumClosest
{
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++)
        {
            int sum = target - num[i];
            int short_i = twoSumClosest(num, i + 1, sum);
            if (short_i == 0) return target;
            if (java.lang.Math.abs(short_i) < java.lang.Math.abs(shortest))
                shortest = short_i;
        }
        
        return target - shortest; 
    }
    private int twoSumClosest(int[] num, int pointer, int sum)
    {
        int shortest_i = Integer.MAX_VALUE;
        int l = pointer, r = num.length - 1;
        while (l < r)
        {
            int diff = sum - num[l] - num[r];
            if(java.lang.Math.abs(diff) < java.lang.Math.abs(shortest_i)) shortest_i = diff;
            if (diff == 0) return 0;
            if (diff > 0) l++;
            else r--;
        }
        return shortest_i;
    }
    public static void main(String[] args)
	{
    	ThreeSumClosest a = new ThreeSumClosest();
    	int[] b = {1,1,1,0};
    	System.out.println(a.threeSumClosest(b,-100));
	}
}
