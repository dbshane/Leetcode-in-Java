
/*Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * */
import java.util.*;


public class LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring(String s)
    {
    	int longest = 0;
    	Hashtable<Character, Integer> set = new Hashtable<Character, Integer>();
    	int i = 0; /*pointer one*/
    	int j = 0; /*pointer two*/
        while (j < s.length())
       	{
       		if(!set.containsKey(s.charAt(j)))
       		{
       			set.put(s.charAt(j),j);
       			j++;
       			if(j - i > longest)   longest = j - i;
       		}
       		else
       		{
       			int n = set.get(s.charAt(j));
       			for (int k = i; k < n; k++)
       				set.remove(s.charAt(k));
        		set.put(s.charAt(j), j);
       			i = n + 1;
       			j++;
       		}
       	}
        return longest;
    }
    public static void main(String[] args)
	{
    	LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
    	System.out.println(a.lengthOfLongestSubstring("abca"));
	}
}
