
public class ExcelSheetColumnNumber
{
    public static int titleToNumber(String s) {
        int total = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            total += (s.charAt(i) - 64) * java.lang.Math.pow(26, s.length() - i - 1);
        }
        return total;
    }
    public static void main(String[] args)
	{
		System.out.println(titleToNumber("BB"));
	}
}
