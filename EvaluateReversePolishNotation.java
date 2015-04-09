import java.util.Stack;


public class EvaluateReversePolishNotation
{
    public static int evalRPN(String[] tokens) {
    	if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++)
        {
            if ((tokens[i].charAt(0)-'0'>= 0 && tokens[i].charAt(0)-'0' <= 9)
            		|| tokens[i].length() > 1)
                stack.push(Integer.parseInt(tokens[i]));
            else
            {
                int b = stack.pop();
                int a = stack.pop();
                switch (tokens[i].charAt(0))
                {
                    case '+': stack.push(a+b);
                              break;
                    case '-': stack.push(a-b);
                              break;
                    case '*': stack.push(a*b);
                              break;
                    case '/': stack.push(a/b);
                              break;
                }
            }
        }
        return stack.pop();
    }
    
     public static void main(String[] args)
	{
		String[] a = {"2", "-1", "+", "3", "*"};
		System.out.println(evalRPN(a));
	}
}
