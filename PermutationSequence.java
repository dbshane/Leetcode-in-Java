import java.util.ArrayList;


public class PermutationSequence
{
    public String getPermutation(int n, int k) {
        int fact = 1;
        int max = 0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i < n+1; i++)
        	num.add(i);
        for (int i = 1; i <= n; i++)
        {
            fact *= i;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
        	fact /= n-i;
        	s.append(num.get((k-1)/fact));
        	num.remove((k-1)/fact);
            k = (k-1)%fact+1;
        }
        return s.toString();
    }
    public static void main(String[] args)
	{
    	PermutationSequence a = new PermutationSequence();
    	
		System.out.println(a.getPermutation(4,1));
		int i = 3;
		StringBuilder c = new StringBuilder();
	}
}
