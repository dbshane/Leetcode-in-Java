import java.util.ArrayList;


public class PalindromePartitioning
{
    public static ArrayList<ArrayList<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--)
            for (int j = i; j < s.length(); j++)
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]))
                    dp[i][j] = true;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        help(s, dp, 0, s.length()-1, new ArrayList<String>(), res);
        return res;
    }
    
    private static void help(String s, boolean[][] dp, int lo, int hi, ArrayList<String> temp, ArrayList<ArrayList<String>> res)
    {
        if (lo > hi)  res.add(new ArrayList<String>(temp));
        for (int i = lo; i <= hi; i++)
        {
            if (dp[lo][i])
            {
                temp.add(s.substring(lo, i+1));
                help(s, dp, i+1, hi, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public static void main(String[] args)
	{
		System.out.println(partition("aab"));
	}
}
