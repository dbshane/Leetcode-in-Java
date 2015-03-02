
public class AddBinary
{
    public static String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        if (al < bl) return addBinary(b,a);
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int temp;
        for (int i = al-1; i >= 0; i--)
        {
            if (i >= al- bl) 
                temp = (a.charAt(i)-'0')+(b.charAt(i-(al-bl))-'0') + carry;
            else temp = (a.charAt(i)-'0') + carry;
            if (temp == 3)
            {
                res.append('1');
                carry = 1;
            }
            else if (temp == 2)
            {
                res.append('0');
                carry = 1;
            }
            else if (temp == 1)
            {
                res.append('1');
                carry = 0;
            }
            else 
            {
                res.append('0');
                carry = 0;
            }
        }
        if (carry == 1)  res.append('1');
        return res.reverse().toString();
    }
    public static void main(String[] args)
	{
		String a = "11111";
		String b = "11111111111";
		System.out.println(addBinary(a,b));
	}
}
