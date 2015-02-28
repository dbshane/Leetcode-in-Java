
public class MultiplyStrings
{
    public static String multiply(String num1, String num2) {
        StringBuilder a = new StringBuilder("0");
        for (int i = num2.length()-1; i >= 0; i--)
            a = add(a, multiply(num1, (int) (num2.charAt(i) -'0'), num2.length()-i-1));
        return a.reverse().toString();
    }
    
    private static StringBuilder multiply(String num, int digit, int n)
    {
        if (num.equals("0") || digit == 0)  return new StringBuilder("0");
        StringBuilder a = new StringBuilder();
        int carryover = 0;
        for (int i = num.length()-1; i >= 0; i--)
        {
            int res = ((int) (num.charAt(i) -'0'))*digit + carryover;
            a.append(res%10);
            carryover = res/10;
            if (i == 0 && carryover != 0) a.append(carryover);
        }
        a = a.reverse();
        for (int i = n; i > 0; i--)   a.append('0');
        a = a.reverse();
        return a;
    }
    
    private static StringBuilder add(StringBuilder num1, StringBuilder num2) 
    {
    	if (num1.toString().equals("0")) return num2;
    	if (num2.toString().equals("0")) return num1;
        StringBuilder p = new StringBuilder();
        int carryover = 0;
        for (int i = 0; i < num2.length(); i++)
        {
            int res;
            if (i <= num1.length()-1)
                 res = ( (int) (num1.charAt(i)-'0') ) + ( (int) (num2.charAt(i) - '0')) + carryover;
            else res = ( (int) (num2.charAt(i) - '0')) + carryover;
            p.append(res%10);
            carryover = res/10;
            if (i == num2.length()-1 && carryover != 0)  p.append(carryover);
        }
        return p;
    }
    public static void main(String[] args)
	{
		System.out.println(multiply("101", "10"));
	}
}
