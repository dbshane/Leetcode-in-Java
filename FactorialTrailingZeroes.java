
public class FactorialTrailingZeroes
{
    public static int trailingZeroes(int n) {
        int res = 0;
        while (n > 0)
        {
            n = n/5;
            res += n;
        }
        return res;
    }
    
    public static void main(String[] args)
	{
		System.out.println(trailingZeroes(27));
	}
}
