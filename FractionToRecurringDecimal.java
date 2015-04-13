import java.util.HashMap;


public class FractionToRecurringDecimal
{
    public static String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        StringBuilder sb = new StringBuilder();
        long numeratorCopy = Math.abs((long) numerator);
        long denominatorCopy = Math.abs((long) denominator);
        long integerPart = (long) numerator/(long) denominator;
        if (integerPart == 0 && 
        	((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)))
        	sb.append('-');
        sb.append(integerPart);
        long rest = numeratorCopy%denominatorCopy;
        if (rest == 0) 
            return sb.toString();
        sb.append('.');
        while (rest != 0)
        {
            rest = rest*10;
            if (map.containsKey(rest))
            {
                sb.insert(map.get(rest).intValue(), '(');
                sb.append(')');
                return sb.toString();
            }
            map.put(rest,sb.length());
            sb.append((int) (rest/denominatorCopy));
            rest = rest % denominatorCopy;
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
	{
		System.out.println(fractionToDecimal(1,3));
	}
}
