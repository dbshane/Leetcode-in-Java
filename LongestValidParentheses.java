import java.util.Stack;


public class LongestValidParentheses
{
    public static int longestValidParentheses(String s) {
        int p = 0, longest = 0;
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] boo = new boolean[s.length()];  //create an boolean array to indicate valid substring
        for (int i = 0; i < s.length(); i++)	boo[i] = false;
        
        while (p < s.length())
        {
        	if (s.charAt(p) == '(')
        	{
        		stack.push(p);   //put the index of pointer
        		p++;
        	}
        	else if (s.charAt(p) == ')')
        	{
        		if (!stack.isEmpty())   //when an index is popped out, then from that index to current index is valid
        			for(int i = stack.pop(); i <= p; i++)	boo[i] = true;
        		p++;
        	}
        }
        int temp = 0;
        for (int i = 0; i < s.length(); i++)	//find the longest valid part from the boolean array
        {
        	if (boo[i])  temp++;
        	if (!boo[i])  temp = 0;
        	if (temp > longest)  longest = temp;
        }
        return longest;
    }
    public static void main(String[] args)
	{
    	System.out.println(longestValidParentheses("())"));
	}
}
