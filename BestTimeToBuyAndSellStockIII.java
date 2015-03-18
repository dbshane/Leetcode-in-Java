
public class BestTimeToBuyAndSellStockIII
{
	// maxProfitRight[] stores the maximum profit on the right side of each element (including the current) in one transaction
	// maxProfitLeft stores the maximum profit on the left side of each element (including the current) in one transaction
	// dp[] calculates the sum of left maximum profit and right maximum profit of each element, and the biggest is the answer
    public static int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
        int[] maxProfitRight = new int[prices.length];
        int max = 0;
        int maxR = 0;
        for (int i = prices.length-1; i >= 0; i--)
        {
            if (prices[i] > max) max = prices[i];
            if (max - prices[i] > maxR) maxR = max - prices[i];
            maxProfitRight[i] = maxR;
        }
        int[] maxProfitLeft = new int[prices.length];
        int min = prices[0];
        int maxL = 0;
        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < min) min = prices[i];
            if (prices[i] - min > maxL) maxL = prices[i] - min; 
            maxProfitLeft[i] = maxL;
        }
        int[] dp = new int[prices.length+1];
        int maxTotal = 0;
        for (int i = 0; i < dp.length; i++)
        {
        	if (i == 0) dp[i] = 0 + maxProfitRight[0];
        	else if (i == dp.length-1) dp[i] = 0 + maxProfitLeft[dp.length-2];
        	else dp[i] = maxProfitLeft[i-1] + maxProfitRight[i];
            if (dp[i] > maxTotal) maxTotal = dp[i];
        }
        return maxTotal;
    }
    
    public static void main(String[] args)
	{
		System.out.println(maxProfit(new int[]{3,4,1,45}));
	}
}
