import java.util.Arrays;


public class BestTimeToBuyAndSellStockII
{
    public static int maxProfit(int[] prices) {
        int[] copy = Arrays.copyOf(prices, prices.length+1);
        int max = 0;
        int index = 0;
        for (int i = 1; i < copy.length; i++)
        {
            if (copy[i] < copy[i-1]) 
            {
                if (index != i-1)
                    max += copy[i-1]-copy[index];
                index = i;
            }
        }
        return max;
    }
    public static void main(String[] args)
	{
		System.out.println(maxProfit(new int[]{1,2,3,4,2,5,6}));
	}
}
