import java.util.ArrayList;


public class ReverseIPAddresses
{
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int[] copy = new int[s.length()];
        for (int i=0; i<copy.length; i++)   copy[i]=Character.getNumericValue(s.charAt(i));
        restore(result, copy, 0, "", 4);
        return result;
    }
    
    private static void restore(ArrayList<String> result, int[] copy, int p, String temp, int n)
    {
        if (p > copy.length-1 && n == 0 ) 
        {
            result.add(temp.substring(1));
            return;
        }
        if (copy.length-p < n || copy.length-p > 3*n)  return;
        restore(result, copy, p+1, temp + "." + copy[p], n-1);
        if (p < copy.length-1 && copy[p] != 0)  restore(result, copy, p+2, temp + "." + copy[p] + copy[p+1], n-1);
        if (p < copy.length-2 && copy[p] != 0 && copy[p]*100+copy[p+1]*10+copy[p+2] < 256)
            restore(result, copy, p+3, temp + "." + copy[p] + copy[p+1] + copy[p+2], n-1);
    }
    public static void main(String[] args)
	{
		System.out.println(restoreIpAddresses("25525511135"));
	}
}
