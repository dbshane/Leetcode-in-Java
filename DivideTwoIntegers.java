
public class DivideTwoIntegers
{
    public static int divide(int dividend, int divisor) {
    	if (dividend == 0 || divisor == 1) return dividend;
    	boolean pos = true;
       	long result = 0;
        if (dividend < 0)	pos = !pos;
        if (divisor < 0) pos = !pos;
        long divisorCopy = java.lang.Math.abs((long) divisor);
        long dividendCopy = java.lang.Math.abs((long) dividend);
        long count = 1;
        while (dividendCopy >= divisorCopy)
        {
            divisorCopy <<= 1;
            count <<= 1;
            if (divisorCopy >= dividendCopy)
            {
            	if (divisorCopy > dividendCopy)
            	{
            		divisorCopy >>= 1;
            		count >>= 1;
            		dividendCopy -= divisorCopy;
            		result += count;
            	}
            	else 
            	{
            		dividendCopy = 0;
            		result += count;
            	}
            	divisorCopy = java.lang.Math.abs((long) divisor);
                count = 1;
            }
        }
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (pos)? (int)result:(int)-result;
    }
    
    public static void main(String[] args)
	{
		System.out.println(divide(-2147483648, -1));
	}
}
