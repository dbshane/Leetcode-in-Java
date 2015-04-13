import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber
{
    public static String largestNumber(int[] num) {
        Integer[] num2 = new Integer[num.length];
        for (int i = 0; i < num.length; i++)
            num2[i] = num[i];
        Arrays.sort(num2, new Comparator<Integer>(){
            public int compare(Integer a, Integer b)
            {
            	// Compare two integers by append one to another
                String s1 = a.toString()+b.toString();
                String s2 = b.toString()+a.toString();
                for (int i = 0; i < s1.length(); i++)
                {
                	char ch1 = s1.charAt(i);
                	char ch2 = s2.charAt(i);
                	if (ch1 > ch2) return 1;
                	if (ch1 < ch2) return -1;
                }
                return 0;
            }
        });
        if (num2[num2.length-1] == 0) return "0";  //To avoid repeated 0
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length-1; i >= 0; i--)
        	sb.append(num2[i]);
        return sb.toString();
    }
    public static void main(String[] args)
	{
		System.out.println(largestNumber(new int[]{0,0,0}));
	}
}
