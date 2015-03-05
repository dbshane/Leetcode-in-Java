
public class SearchInRotatedSortedArrayII
{
    public boolean search(int[] A, int target) {
        int lo = 0;
        int hi = A.length;
        while (lo <= hi)
        {
            int mid = (lo+hi)/2;
            if (A[lo] >= A[hi])
            {
                if (A[mid] == target) return true;
                if (A[mid] < A[lo])
                {
                    if (target > A[mid] && target < A[lo]) lo = mid+1;
                    else hi = mid-1;
                }
                else if (A[mid] > A[lo]){}
            }
            else
            {
                if (A[mid] == target) return true;
                if (A[mid] > target) hi = mid-1;
                else lo = mid+1;
            }
        }
        return false;
    }
}
