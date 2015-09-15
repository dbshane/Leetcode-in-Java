import java.util.HashSet;


public class HappyNumber
{
    public static boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1)
        {
            sum = 0;
            while (n != 0)
            {
                sum += (n%10)*(n%10);
                n = n/10;
            }
            if (set.contains(sum))
            	break;
            set.add(sum);
            n = sum;
        }
        if (n == 1) return true;
        else return false;
    }
    
    
    public static void main(String[] args)
	{
    	System.out.println(isHappy(19));
    }
}
