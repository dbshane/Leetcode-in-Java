
public class JumpGame
{
    public static boolean canJump(int[] A) {
        int max = 0, i = 0;
        while (max >= i && i < A.length)
        {
            max = Math.max(i + A[i], max);
            i++;
            if (max >= A.length-1) return true;
        }
        return false;
    }
    public static void main(String[] args)
	{
		int[] a = {3,2,1,0,4};
		System.out.println(canJump(a));
	}
}
