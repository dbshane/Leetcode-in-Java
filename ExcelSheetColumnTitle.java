
public class ExcelSheetColumnTitle
{
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0)
        {
            sb.append((char) ((n-1)%26 + 'A'));
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args)
	{
		System.out.println(convertToTitle(200));
	}
}
