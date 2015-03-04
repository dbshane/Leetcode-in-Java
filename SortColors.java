
public class SortColors
{
    public static void sortColors(int[] A) {
        int lp = 0;
        int rp = A.length-1;
        int curr = 0;
        int temp = 0;
        while (curr <= rp)
        {
            if (A[curr] == 1) curr++;
            else if (A[curr] == 0)
            {
                while (A[lp] == 0 && lp < curr) lp++;
                temp = A[lp];
                A[lp] = A[curr];
                A[curr] = temp;
                curr++;
            }
            else
            {
                while (A[rp] == 2 && rp > curr) rp--;
                temp = A[rp];
                A[rp] = A[curr];
                A[curr] = temp;
                if (A[curr] != 0) curr++;
            }
        }
    }
    public static void main(String[] args)
	{
		int[] a = {0,1};
		sortColors(a);
		for (int i: a)
		System.out.println(i);
		
	}
}
