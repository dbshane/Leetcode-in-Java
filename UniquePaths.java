import java.math.BigDecimal;


public class UniquePaths   // Math method, slow
{
    public static int uniquePaths(int m, int n) {
    	BigDecimal fact = new BigDecimal(1);
    	BigDecimal nFact = new BigDecimal(1);
    	BigDecimal mFact = new BigDecimal(1);
        for (int i = 1; i <= m+n-2; i++)
        {
            fact = fact.multiply(new BigDecimal(i));
            if (i == n-1) nFact = fact;
            if (i == m-1) mFact = fact;
        }
        return fact.divide(mFact.multiply(nFact)).intValue();
    }
    public static void main(String[] args)
	{
		System.out.println(uniquePaths(19,13));
	}
}
