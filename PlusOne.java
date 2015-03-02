
public class PlusOne
{
    public static int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l-1; i >= 0; i--)
        {
        	System.out.println(i);
            if (digits[i] < 9)
            {
                digits[i] += 1;
                break;
            }
            else
            {
                digits[i] = 0;
                if (i == 0)
                {
                    int[] res = new int[l+1];
                    res[0] = 1;
                    for (int j = 1; j < l+1; j++)
                        res[j] = digits[j-1];
                    return res;
                }
            }
        }
        return digits;
    }
    public static void main(String[] args)
	{
		int[] a = {9,9,9,9,0,9};
		int[] b = plusOne(a);
		for (int i = 0; i < b.length; i++)
			
		System.out.println(b[i]);
	}
}
