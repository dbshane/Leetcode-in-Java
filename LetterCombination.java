import java.util.*;

public class LetterCombination
{
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        String[] dict = {" ", "", "abc","def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder temp = new StringBuilder();
        generate(digits, dict, 0, temp, result);
        return result;
    }
    private static void generate(String digits, String[] dict, int p, StringBuilder temp, ArrayList<String> result)
    {
        if (p == digits.length())
        {
            result.add(temp.toString());
            return;
        }
        int number = Character.getNumericValue(digits.charAt(p));
        for (int i = 0; i < dict[number].length(); i++)
        {
            temp.append(dict[number].charAt(i));
            generate(digits, dict, p + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public static void main(String[] args)
	{
    	String digits = "234";
		System.out.println(letterCombinations(digits));
	}
}
