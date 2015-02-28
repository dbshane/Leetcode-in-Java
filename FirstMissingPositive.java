
public class FirstMissingPositive
{
    public static int firstMissingPositive(int[] A) {
    	int temp = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] > 0 && A[i] < A.length && A[i] != A[A[i]-1])
            {
                temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != i+1) return i+1;
        }
        return A.length+1;
    }
    
    public static void main(String[] args)
	{
    	int[] A = {0,2,2,1,1};
		System.out.println(firstMissingPositive(A));
	}
}
