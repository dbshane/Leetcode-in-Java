import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Anagrams
{
	public static ArrayList<String> anagrams(String[] strs)
	{
		ArrayList<String> result = new ArrayList<String>();
		Hashtable<String, Integer> map = new Hashtable<String, Integer>();
		for (int i = 0; i < strs.length; i++)
		{
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String sorted = new String(charArray);
			if (map.containsKey(sorted))
			{
				if (!result.contains(strs[map.get(sorted)]))
					result.add(strs[map.get(sorted)]);
				result.add(strs[i]);
				map.put(strs[i], i);
			} else
			{
				map.put(sorted, i);
				map.put(strs[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		String[] a = {"abc", "bac", "dna", "cba", "cba", "adn", "", ""};
		System.out.println(anagrams(a));
	}
}
