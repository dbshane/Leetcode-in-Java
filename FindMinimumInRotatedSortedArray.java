
public class FindMinimumInRotatedSortedArray
{
    public static int findMin(int[] num) {
        int lo = 0, hi = num.length-1, mid;
        while(lo != hi)
        {
            mid = (lo+hi)/2;
            if (num[lo] > num[hi])
            {
                if (num[mid] < num[lo])
                    hi = mid;
                else lo = mid+1;
            }
            else return num[lo];
        }
        return num[lo];
    }
    public static void main(String[] args)
	{
		int[] a = {7,8,9};
		System.out.println(findMin(a));
	}
}
