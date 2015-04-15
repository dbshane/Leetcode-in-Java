
public class ReverseBits
{
    public static int reverseBits(int n) {
    	long n1 = (long) n;
        int move  = 31;
        long k = 1;
        long result = 0, add = 0, windowRight = 1, windowLeft = k<<31;
        System.out.println(windowLeft);
        for (int i = 0; i < 16; i++)
        {
            add = (n1&windowRight) << move | (n1&windowLeft) >> move;
        	move -= 2;
            result |= add;
            windowRight <<= 1;
            windowLeft >>= 1;
        }
        return (int) result;
    }
    public static void main(String[] args)
	{
		System.out.println(reverseBits(131072));
	}
}
