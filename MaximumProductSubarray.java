
public class MaximumProductSubarray
{
	//tempMax is used to store the maximum value containing current A[i]
	//tempMin is used to store the minimum value containing current A[i]
    public static int maxProduct(int[] A) {
        int max = A[0], tempMax = A[0], tempMin = A[0];
        for (int i = 1; i < A.length; i++)
        {
        	int tempMax1 = tempMax * A[i];
        	int tempMin1 = tempMin * A[i];
        	tempMax = Math.max(Math.max(tempMax1, tempMin1), A[i]);
            tempMin = Math.min(Math.min(tempMax1, tempMin1), A[i]);
            max = Math.max(tempMax, max);
        }
        return max;
    }
    public static void main(String[] args)
	{
		int A[] = {0,2,-3,-6};
		System.out.println(maxProduct(A));
	}
}
