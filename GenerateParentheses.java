import java.util.*;

public class GenerateParentheses
{

	public static List<String> generateParenthesis(int n) {
	    ArrayList<String> result = new ArrayList<String>();
	    generate(result, "", 0, 0, n);
	    return result;
	}

	private static void generate(ArrayList<String> result, String temp, int l, int r, int n)
	{
		if (l < r)
	    	return;
	    if (l < n)
	        generate(result, temp + "(", l + 1, r, n);
	    if (r < n) 
	        generate(result, temp + ")", l, r + 1, n);
	    if (l == n && r == n)
	    {
	        result.add(temp.toString());
	        return;
	    }
	}
    public static void main(String[] args)
	{
		System.out.println(generateParenthesis(5));
	}
}


