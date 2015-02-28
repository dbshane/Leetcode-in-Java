
public class MedianOfTwoSortedArrays
{
	public double findMedianSortedArrays(int A[], int B[])
	{
        int m = A.length;
        int n = B.length;
        double median;
        if ((m + n)%2 == 0)  median = (findkth(A, B, m, n, (m + n)/2 - 1) + findkth(A, B, m, n, (m + n )/2))/2;
        else median = findkth(A, B, m, n, (m + n)/2);
        return median;
    }
	
	private double findkth(int A[], int B[], int m, int n, int k)
	{
		Math.max(m, n);  //wrong
		return 0; //wrong
	}
}
