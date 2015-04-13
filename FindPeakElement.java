
public class FindPeakElement
{
	//The idea is binary search an area (lo, hi), making sure num[lo-1] < num[lo] num[hi+1] < num[hi]
    public static int findPeakElement(int[] num) {
        if (num.length == 1) return 0;
        int lo = 0, hi = num.length-1;
        while (lo != hi)
        {
            int mid = (lo+hi)/2;
            if (num[mid] < num[mid+1])
                lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
    
    public static void main(String[] args)
	{
		int[] num = {1,2,3,1};
		System.out.println(findPeakElement(num));
	}
}
