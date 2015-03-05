
public class RemoveDuplicatesFromSortedArrayII
{
    public static int removeDuplicates(int[] A) {
        int lp = 0, rp = 0, count = 0;
        while (rp < A.length)
        {
            if (rp == 0 || (A[rp] == A[rp-1] && count < 2))
            {
                A[lp] = A[rp];
                lp++;
                count++;
                rp++;
            }
            else if (A[rp] != A[rp-1])
            {
            	count = 0;
            	A[lp] = A[rp];
            	lp++;
            	rp++;
            	count++;
            }
            else
                rp++;
        }
        for (int i = lp; i < A.length; i++)
        	A[i] = 0;
        return lp;
    }
    public static void main(String[] args)
	{
		int[] A = {0,1,1,1,1,1,2,2,2};
		System.out.println(removeDuplicates(A));
		for(int i: A)
		System.out.println(i);
	}
}
