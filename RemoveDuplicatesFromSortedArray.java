
public class RemoveDuplicatesFromSortedArray
{
    public static int removeDuplicates(int[] A) {
        int l = 0;
        int r = 0;
        while (r < A.length)
        {
            if (A[l] == A[r])
            {
                r++;
            }
            else
            {
                A[l + 1] = A[r];
                l++;
                r++;
            }
        }
        for (int i = l + 1; i < A.length; i++)
        {
        	A[i] = 0;
        }
        return l + 1;
    }
    public static void main(String[] args)
	{
		int[] A = {1};
		System.out.println(removeDuplicates(A));
		for(int i = 0; i < A.length; i++)
		{
			System.out.println(A[i]);
		}
	}
}
