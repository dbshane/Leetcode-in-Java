import java.util.Stack;


public class ReverseWordsInAString
{
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == ' ')
            {
                if (sb.length() != 0)
                {
                    stack.push(sb.toString());
                    sb.delete(0,sb.length());
                }
            }
            else
                sb.append(ch);
        }
        if (sb.length() != 0)
        {
            stack.push(sb.toString());
            sb.delete(0,sb.length());
        }
        while (!stack.isEmpty())
        {
            sb.append(stack.pop());
            sb.append(' ');
        }
        if (sb.length() != 0)
        	sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args)
	{
		System.out.println(reverseWords("the-sky is blue  "));
	}
}
