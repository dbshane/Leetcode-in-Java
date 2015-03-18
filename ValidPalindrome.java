
public class ValidPalindrome
{
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
        	char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z')|| (c >= '0' && c <= '9'))
                sb.append(s.charAt(i));
        }
        s = sb.toString();
        int lo = 0;
        int hi = s.length()-1;
        while (lo < hi)
        	if (s.charAt(lo++) != s.charAt(hi--))  return false;
        return true;
    }
    public static void main(String[] args)
	{
		System.out.println(isPalindrome("aAa"));
	}
}
