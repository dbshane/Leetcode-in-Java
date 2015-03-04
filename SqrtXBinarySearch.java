
public class SqrtXBinarySearch
{
	public static int sqrt(int x) {  
	    if (x == 0 || x == 1) return x;
	    int lo = 1;
	    int hi = x;
	    while(lo <= hi)
	    {
	        int mid = (lo+hi)/2;
	        if(mid <= x/mid && x/(mid+1)<mid+1)
	            return mid;
	        if(x/mid < mid)
	            hi = mid-1;
	        else
	            lo = mid+1;
	    }
	    return 0;
	}
    public static void main(String[] args)
	{
		System.out.println(sqrt(21));
	}
}
