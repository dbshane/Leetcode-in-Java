
public class TrappingRainWater
{
    public static int trap(int[] A) {
        int max = 0;
        int[] left = new int[A.length];
        for (int i = 0; i < A.length; i++)
        {
            left[i] = max;
            if (A[i] > max) max = A[i];
        }
        max = 0;
        int[] right = new int[A.length];
        for (int i = A.length-1; i >= 0; i--)
        {
            right[i] = max;
            if (A[i] > max) max = A[i];
        }
        int total = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (left[i] > A[i] && right[i] > A[i])  total += java.lang.Math.min(left[i],right[i])-A[i];
        }
        return total;
    }
    public static void main(String[] args)
	{
    	int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}
}
