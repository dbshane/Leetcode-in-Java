
public class DistinctSubsequences
{
    public static int numDistinct(String S, String T) {
        int tl = T.length();
        int sl = S.length();
        if (sl < tl) return 0;
        int[][] dp = new int[tl][sl];
        int count = 0;
        for (int j = 0; j < sl; j++) 
            if (S.charAt(j) == T.charAt(0))
            {
                dp[0][j] = ++count;
            }
            else dp[0][j] = count;
        for (int i = 1; i < tl; i++)
            for (int j = i; j < sl; j++)
            {
                if (S.charAt(j) == T.charAt(i))
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];  
                else dp[i][j] = dp[i][j-1];
            }
        return dp[tl-1][sl-1];   
    }
    
    public static void main(String[] args)
	{
		System.out.println(numDistinct("RRABBBIT", "RABBIT"));
	}
}


/*
 *  example:  R A R B A
 * 			R 1 1 2 2 2
 * 			A 0 1 1 1 3
 * 			A 0 0 0 0 1
 * 	this array's dp[i][j] is the number of subsequences for S's 0~j chars that equals T's 0~i chars.
 * 	dp[i][j-1] is the number of subsequences without this character,
 *  and dp[i-1][j-1] is the number of subsequences with this character.
 */
