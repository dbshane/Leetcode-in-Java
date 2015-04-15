
public class RotateArray
{
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    
    private static void reverse(int[] nums, int lo, int hi)
    {
        while (lo < hi)
        {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
    
    public static void main(String[] args)
	{
		int[] a = {-1,2};
		rotate(a,3);
		for (int i:a) System.out.println(i);
	}
}
