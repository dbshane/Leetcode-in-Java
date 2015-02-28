public class RomanToInteger
{
    public int romanToInt(String s) {
        String[] ch = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int total = 0;
        for (int i = 0; i < ch.length; i++)
        {
            while (s.startsWith(ch[i]))
            {
            	total += a[i];
                if (ch[i].length() == 1)
                s = s.substring(1);
                else s = s.substring(2);
            }
        }
        return total;
    }
    public static void main(String args[])
    {
    	RomanToInteger a = new RomanToInteger();
    	System.out.println(a.romanToInt("DCL"));
    }
}
