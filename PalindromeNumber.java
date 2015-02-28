
public class PalindromeNumber
{
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int i = 0;
        int last = x % 10;
        int xcopy = x;
        do
        {
            x = x / 10;
            i++;
        }
        while (x >= 10);
        if (last != x) return false;
        int remainder = xcopy - (int) (x * Math.pow(10, i));
        int j = 0;
        while (remainder > 0)
        {
        	remainder = remainder / 10;
        	j++;
        }
        if (((xcopy - last) / 10) % (int) Math.pow(10, i - j) != 0) return false;
        else return isPalindrome((xcopy - (int) (x * Math.pow(10, i)) - last)/ (int) Math.pow(10, i - j + 1));
    }
    public static void main(String[] args)
	{
		PalindromeNumber a = new PalindromeNumber();
		System.out.println(a.isPalindrome(1000011));
	}
}
