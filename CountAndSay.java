
public class CountAndSay
{
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String a = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        for (int i = 1, temp = 1; i < a.length(); i++)
        {
        	if (a.charAt(i) == a.charAt(i-1)) temp++;
        	else
        	{
        		result.append(temp);
        		result.append(a.charAt(i-1));
        		temp = 1;
        	}
        	if (i == a.length()-1)
        	{
        		result.append(temp);
        		result.append(a.charAt(i));
        	}
        	
        }
        return result.toString();
    }
    public static void main(String[] args)
	{
		System.out.println(countAndSay(6));
	}
}
