
public class MaximumSubarray
{
    public int maxSubArray(int[] A) {
        if (A.length == 0 || A == null)  return 0;
        int global = A[0];			//Maintain global(i) for largest-sum range from 0 to i,
        int local = A[0];			//Maintain local(i) for largest-sum range including A[i]
        for (int i = 1; i < A.length; i++)
        {
            local = Math.max(local+A[i], A[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}
