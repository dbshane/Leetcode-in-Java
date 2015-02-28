
public class StringToInteger
{
    public int atoi(String str) {
    	if (str.length() == 0) return 0;
        char[] charArray = str.toCharArray();
        int i = 0;
        double value = 0;
        int isPositive = 1;
        while(Character.isWhitespace(charArray[i]))
        {
        	if (i == charArray.length - 1) return 0;
        	i++;
        }
        if (charArray[i] == '-')  
        {
            isPositive = -1;
            i++;
        }
        else if (charArray[i] == '+') i++;
        else if (!Character.isDigit(charArray[i])) return 0;
        while (i < charArray.length && Character.isDigit(charArray[i]))
        {
            value = value * 10 + Character.getNumericValue(charArray[i]);
            i++;
        }
        value = isPositive * value;
        if (value > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if (value < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        	
        return (int) value;
    }
    public static void main(String[] args)
	{
		StringToInteger a = new StringToInteger();
		System.out.println(a.atoi("2147483648"));
	}
}
