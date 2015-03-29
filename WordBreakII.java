import java.util.ArrayList;
import java.util.HashSet;


public class WordBreakII
{
    public static ArrayList<String> wordBreak(String s, HashSet<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String>[] dp = (ArrayList<String>[]) new ArrayList[s.length()+1];
        for (int i = 0; i < dp.length; i++)
        	dp[i] = new ArrayList<String>();
        dp[0].add("");
        for (int i = 0; i < s.length()+1; i++)
        {
            if (dp[i].isEmpty()) continue;
            for (String sd: dict)
            {
                int end = i+sd.length()-1;
                if (end > s.length()-1) continue;
                else if (s.substring(i, end+1).equals(sd))
                    dp[end+1].add(sd);
            }
        }
        helper(dp, dp.length-1, new ArrayList<String>(), res);
        return res;
    }
    
    private static void helper(ArrayList<String>[] dp, int p, ArrayList<String> temp, ArrayList<String> res)
    {
        if (p == 0)
        {
        	StringBuilder sb = new StringBuilder();
        	for (int i = temp.size()-1; i >= 0; i--)
        	{
        		sb.append(temp.get(i));
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        for (String sdp: dp[p])
        {
        	temp.add(sdp);
        	helper(dp, p-sdp.length(), temp, res);
        	temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args)
	{
		HashSet<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak("catsanddog",dict));
	}
}
