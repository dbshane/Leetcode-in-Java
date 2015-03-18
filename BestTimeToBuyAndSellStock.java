
public class BestTimeToBuyAndSellStock
{
    public static int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
        int max = 0;
        int diff[] = new int[prices.length];
        for (int i = prices.length-1; i >= 0; i--)
        {
        	if (prices[i] > max) max = prices[i];
            diff[i] = max - prices[i];
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < diff.length; i++)
            if (diff[i] > maxProfit) maxProfit = diff[i];
        return maxProfit;
    }
    public static void main(String[] args)
	{
		System.out.println(maxProfit(new int[]{1}));
	}
}
