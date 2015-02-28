import java.util.Stack;


public class ValidParentheses
{
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i))
            {
                case '[':   st.push('[');
                            break;
                case ']':   if (st.isEmpty() || st.pop() != '[') return false;
                			else break; 
                case '(':   st.push('(');
                            break;
                case ')':   if (st.isEmpty() || st.pop() != '(') return false;
                			else break; 
                case '{':    st.push('{');
                            break;
                case '}':   if (st.isEmpty() || st.pop() != '{') return false;
                			else break; 
            }
        }
        if (st.isEmpty())
        {
        	return true;
        }
        else return false;
    }
    private static int[] apair(int a, int b)
    {
    	int[] pair = new int[2];
    	pair[0] = a;
    	pair[1] = b;
    	return pair;
    }
    public static void main(String[] args)
	{
    	int[] a = apair(3,4);
    	System.out.println(a.length);
	}
}
