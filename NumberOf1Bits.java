
public class NumberOf1Bits
{
    public static int hammingWeight(int n) {
        int count = 0, window = 1;
        for (int i = 0; i < 32; i++)
        {
            if ((n&window) != 0) count++;
            window <<= 1;
        }
        return count;
    }
    public static void main(String[] args)
	{
		System.out.println(hammingWeight(11));
	}
}
