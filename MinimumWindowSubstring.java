import java.util.HashMap;

public class MinimumWindowSubstring
{
    public static String minWindow(String S, String T) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> met = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++)
        {
        	if (!need.containsKey(T.charAt(i)))
        	{
        		need.put(T.charAt(i), 1);
        		met.put(T.charAt(i), 0);
        	}
        	else need.put(T.charAt(i), need.get(T.charAt(i))+1);
        }
        int start = 0, end = 0, count = 0, min = Integer.MAX_VALUE;
        String curr = "";
        while (end < S.length())
        {
        	char c = S.charAt(end);
        	if (!need.containsKey(c))
        	{
        		end++;
        		continue;
        	}
        	if (met.get(c) < need.get(c))
        		count++;
        	met.put(c, met.get(c)+1);
        	end++;
        	if (count == T.length())
        	{
        		while (start <= end)
        		{
        			char sc = S.charAt(start);
        			if (!need.containsKey(sc))	start++;
        			else if (met.get(sc) > need.get(sc))
        			{
        				met.put(sc, met.get(sc)-1);
        				start++;
        			}
        			else break;
        		}
        		if (end-start < min)
        		{
        			min = end-start;
        			curr = S.substring(start,end);
        		}
        		met.put(S.charAt(start), met.get(S.charAt(start))-1);
        		count--;
        		start++;
        	}
        }
        return curr;
    }
    public static void main(String[] args)
	{
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
