import java.util.Arrays;


public class NextPermutation
{
    public static void nextPermutation(int[] num) {
        if (num.length == 0 || num.length == 1) return;
        int p = num.length-2;
        while (p >= 0)
        {
            if (num[p] < num[p+1]) //find first descending number from right end
            {
                int min = Integer.MAX_VALUE;                    //find the smallest number bigger than p on the right side
                int count = p;								
                for (int i = p+1; i < num.length; i++)
                {
                    if (num[i] < min && num[i] > num[p])
                    {
                        count = i;
                        min = num[i];
                    }
                }
                swap(num, count, p);    //swap p and that smallest number
                break;
            }
            p--;
        }
        Arrays.sort(num, p+1, num.length);  //sort the right side of p
        return;
    }
    private static void swap(int[] num, int i, int j)
    {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public static void main(String[] args)
	{
		int[] num = {1,3,2};
		nextPermutation(num);
	 	for(int i=0;i<num.length;i++)
	 	System.out.println(num[i]);
	}
}
