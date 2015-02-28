
public class PowXN
{
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (x == 1) return 1;
        if (x == 0 && n > 0) return 0;
        if (x == 0 && n < 0) return Double.MAX_VALUE;
        if (n < 0)
        {
            x = 1/x;
            n = -n;
        }
        return power(x, n);
    }
    
    private static double power(double x, int n)
    {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n%2 == 0)
        	return power(x*x, n/2);
        else return power(x*x, n/2)*x;
    }
    
    public static void main(String[] args)
	{
		System.out.println(pow(0.2124,-1));
	}
}
