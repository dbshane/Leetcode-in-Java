
public class SearchInsertPosition
{
    public static int searchInsert(int[] A, int target) {
        return search(A, 0, A.length-1, target);
    }
    
    private static int search(int[] A, int lo, int hi, int target)
    {
        int mid = (lo+hi)/2;
        if (A[mid] == target) return mid;
        if (lo == hi)
        {
        	if (target > A[lo]) return lo+1;
        	else return lo;
        }
        if (lo == hi-1)
        {
            if (target < A[lo]) return lo;
            else if (target > A[hi]) return hi+1;
            else return hi;
        }
        if (target < A[mid]) return search(A, lo, mid-1, target);
        else return search(A, mid+1, hi, target);
    }
    public static void main(String[] args)
	{
		int[] A = {1,3,5,6};
		System.out.println(searchInsert(A,2));
	}
}
