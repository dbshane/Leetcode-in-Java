
public class SingleNumberII
{
    public static int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++)
        {
            int count = 0;
            for (int a: A)
                count += (a >> i) & 1;
            res |= (count%3) << i;
        }
        return res;
    }
    
    public static void main(String[] args)
	{
		System.out.println(singleNumber(new int[]{2,2,3,2}));
	}
}
