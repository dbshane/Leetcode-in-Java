public class IntegerToRoman
{
	    public String intToRoman(int num) {
	        StringBuffer s = new StringBuffer();
	        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	        String[] b = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	        for (int i = 0; i < a.length; i++)
	        {
	            while (num >= a[i])
	            {
	                s.append(b[i]);
	                num -= a[i];
	            }
	        }
	        return s.toString();
	    }
	    
	    public static void main(String args[])
	    {
	    	IntegerToRoman a = new IntegerToRoman();
	    	System.out.println(a.intToRoman(4));
	    }
}
