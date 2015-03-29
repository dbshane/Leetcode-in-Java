
public class Candy
{
	
	// the kid only get more candies if they get a higher rating than his neighbor
	// e.g.: 1 2 2, the 2nd kid get higher rating than 1st kid, but the 3rd kid didn't get higher
	// rating than the 2nd kid, so the 3rd kid only get one candy, so candy[] should be 1, 2, 1
	
	// this is not a DP problem, more like the traping water problem
    public static int candy(int[] ratings) {
    	int l = ratings.length;
    	if (l == 0) return 0;
        int[] minLeft = new int[l];
        int[] minRight = new int[l];
        minLeft[0] = 1;
        int base = 1;
        // scan from left to right, only consider left side's minimum
        for (int i = 1; i < l; i++)
        {
            if (ratings[i] <= ratings[i-1])
            {
                minLeft[i] = 1;
                base = 1;
            }
            else minLeft[i] = ++base;
        }
        minRight[l-1] = 1;
        base = 1;
        // scan from right to left, only consider right side's minimum
        for (int i = l-2; i >= 0; i--)
        {
            if (ratings[i] <= ratings[i+1])
            {
                minRight[i] = 1;
                base = 1;
            }
            else minRight[i] = ++base;
        }
        int sum = 0;
        // for each i, get the bigger one for minLeft[i] and minRight[i]
        for (int i = 0; i < l; i++)
            sum += Math.max(minLeft[i], minRight[i]);
        return sum;
    }
    public static void main(String[] args)
	{
		System.out.println(candy(new int[]{5,0,4,2,1,1,2}));
	}
}
