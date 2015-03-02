
public class LengthOfLastWord
{
    public static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length()-1; i>=0; i--)
        {
            if (s.charAt(i) != ' ') count++;
            if (count != 0 && s.charAt(i) == ' ') break;
        }
        return count;
    }
    public static void main(String[] args)
	{
		String s = " a  ";
		System.out.println(lengthOfLastWord(s));
	}
}
