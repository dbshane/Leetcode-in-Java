
public class SearchForARange
{
    public static int[] searchRange(int[] A, int target) {
        int a = search(A, 0, A.length-1, target);
        if (a == -1) return new int[] {-1, -1};
        int lp = a, rp = a;
        while (lp != 0 && A[lp-1] == target)  if (lp > 0) lp--;
        while (rp != A.length-1 && A[rp+1] == target)  if (rp < A.length-1) rp++;
        return new int[] {lp, rp};
    }
    
    private static int search(int[] A, int lo, int hi, int target)
    {
        int mid = (lo+hi)/2;
        if (lo > hi) return -1;
        if (target < A[mid]) return search(A, lo, mid-1, target);
        else if (target > A[mid]) return search(A, mid+1, hi, target);
        else return mid;
    }
    public static void main(String[] args)
	{
		int[] A = {1};
		for (int i = 0; i < 2; i++)
			System.out.println(searchRange(A, 0)[i]);
	}
}
