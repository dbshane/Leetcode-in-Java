
public class FindMinimumInRotatedSortedArrayII
{
    public static int findMin(int[] num) {
        int lo = 0, hi = num.length-1, mid;
        while (lo != hi)
        {
            mid = (lo+hi)/2;
            if (num[lo] >= num[hi])
            {
                if (num[mid] < num[lo])
                    hi = mid;
                else if (num[mid] > num[lo])
                    lo = mid+1;
                else
                {
                    int min = Integer.MAX_VALUE;
                    for (int i = lo; i <= hi; i++)
                        if (num[i] < min) min = num[i];
                    return min;
                }
            }
            else return num[lo];
        }
        return num[lo];
    }
    public static void main(String[] args)
	{
		int[] a = {7,2,3,7,7,7,7,7};
		System.out.println(findMin(a));
	}
}
