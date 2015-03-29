import java.util.HashSet;


public class WordBreak
{
    public static boolean wordBreak(String s, HashSet<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length()+1; i++)
        {
            if (!dp[i]) continue;
            for (String sd: dict)
            {
                int end = i+sd.length()-1;
                if (end > s.length()-1) continue;
                else if (s.substring(i, end+1).equals(sd))
                    dp[end+1] = true;
            }
        }
        return dp[dp.length-1];
    }
    
    public static void main(String[] args)
	{
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("sd");
    	dict.add("s");
		System.out.println(wordBreak("sdsdd", dict));
	}
}
