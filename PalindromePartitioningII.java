
public class PalindromePartitioningII
{
    public static int minCut(String s) {
    	int l = s.length();
    	if (l == 0) return 0;
    	int[] cut = new int[l]; // cut[i] is the min cut from i to s.length()-1
        boolean[][] dp = new boolean[l][l];
        for (int i = l-1; i >= 0; i--)
        {
            cut[i] = Integer.MAX_VALUE;
            for (int j = i; j < l; j++)
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if (j == l-1) cut[i]= 0;
                    else cut[i] = Math.min(cut[j+1]+1, cut[i]);
                }
        }
        return cut[0];
    }
    public static void main(String[] args)
	{
    	System.out.println(minCut("abbab"));
	}
}