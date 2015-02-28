public class SearchInRotatedSortedArray
{
	public static int search(int[] A, int target)
	{
		return search(A, 0, A.length-1, target);
	}

	private static int search(int[] A, int lo, int hi, int target)
	{
		int mid = (lo + hi) / 2;
		if (lo > hi)
			return -1;
		if (A[mid] == target)
			return mid;
		if (A[lo] > A[hi]) {
			if (A[mid] < A[lo]) {
				if (target >= A[lo] || target < A[mid])
					return search(A, lo, mid-1, target);
				else if (target > A[mid])
					return search(A, mid + 1, hi, target);
				else
					return -1;
			} else {
				if (target > A[mid] || target <= A[hi])
					return search(A, mid + 1, hi, target);
				else if (target < A[mid])
					return search(A, lo, mid-1, target);
				else
					return -1;
			}
		} else {
			if (target < A[lo] || target > A[hi])
				return -1;
			if (target > A[mid])
				return search(A, mid + 1, hi, target);
			else
				return search(A, lo, mid, target);
		}
	}
	public static void main(String[] args)
	{
		int[] A = {7,8,9,1,2,3};
		System.out.println(search(A,8));
	}
}
