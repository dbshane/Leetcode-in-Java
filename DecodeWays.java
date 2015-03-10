
public class DecodeWays
{
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++)
        {
            int temp = (s.charAt(i-1)-'0')*10+s.charAt(i)-'0';  // build the number. eg "09" -> 9,  "56" -> 56
            if (temp == 10 || temp ==20) dp[i] = i>=2?dp[i-2]:1;
            else if (temp%10 == 0) dp[i] = 0;
            else dp[i] = dp[i-1];
            if ((temp > 10 && temp < 20) || (temp > 20 && temp <= 26)) dp[i] += i>=2?dp[i-2]:1;
        }
        return dp[s.length()-1];
    }
    public static void main(String[] args)
	{
		System.out.println(numDecodings("230"));
	}
}
