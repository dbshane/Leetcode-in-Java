
public class JumpGameII2   //Greedy
{
    public static int jump(int[] A)
    {
    	if (A.length == 0 || A.length == 1) return 0;
    	int i = 0, max = 0, temp = 0, count = 0;
    	while (max < A.length -1)
    	{
    		while (i <= temp)
    		{
    			max = Math.max(max, i+A[i]);
    			i++;
    		}
    		count++;
    		temp = max;
    	}
    	return count;
    }
    public static void main(String[] args)
	{ 
    	int[] a = new int[25000];
    	for (int i = 0; i < a.length; i++)
    		a[i] = 25000 - i;
		System.out.println(jump(a));
	}
}
