import java.util.ArrayList;

public class Triangle
{
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int height = triangle.size();
        if (height == 0) return 0;
        int[] dp = new int[height];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < height; i++)
        {
            dp[i] = dp[i-1] + triangle.get(i).get(i);
            for (int j = i-1; j >= 1; j--)
                dp[j] = Math.min(dp[j-1], dp[j]) + triangle.get(i).get(j);
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++)
        	if (dp[i] < min) min = dp[i];
        return min;
    }
    
    public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(5);
		d.add(7);
		d.add(6);
		ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
		c.add(a);
		c.add(b);
		c.add(d);
		System.out.println(minimumTotal(c));
	}
}
