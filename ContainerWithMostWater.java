public class ContainerWithMostWater
{
    public int maxArea(int[] height) {
        int length = height.length;
        int i = 0, j = length - 1;
        int maxArea = area(j-i, height[i], height[j]);
        while (i < j)
        {
            if (area(j-i, height[i], height[j]) > maxArea)
            {
                maxArea = area(j-i, height[i], height[j]);
            }
            if (height[i] < height[j])
            {
                i++;
            }
            else j--;
        }
        return maxArea;
    }
    
    private int area(int width, int left, int right)
    {
        return width * (java.lang.Math.min(left, right));
    }
    
    public static void main(String[] args)
    {
    	int[] a = {11,2,11,4,5};
    	ContainerWithMostWater b = new ContainerWithMostWater();
    	System.out.println(b.maxArea(a));
    }
}
