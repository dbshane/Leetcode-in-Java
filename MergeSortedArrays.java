
public class MergeSortedArrays
{
    public static void merge(int A[], int m, int B[], int n) {
        int ap = m-1;
        int bp = n-1;
        for (int i = m+n-1; i >= 0; i--)
        {
        	// if bp<0, the left side of ap doesn't need to change
            if (bp >= 0 && ap >= 0 && A[ap] > B[bp]) 
                A[i] = A[ap--];
            else if (ap < 0 || (bp >= 0 && B[bp] >= A[ap]))
            	A[i] = B[bp--];
        }
    }
    public static void main(String[] args)
	{
		int[] A = new int[10];
		for (int i = 0; i < 5; i++)
			A[i] = i;
		int[] B = new int[7];
		for (int i = 2 ; i < 5; i++)
			B[i-2] = i;
		merge(A,5,B,3);
		for (int i: A) System.out.println(i);
	}
}
