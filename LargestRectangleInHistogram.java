import java.util.Arrays;
import java.util.Stack;


public class LargestRectangleInHistogram
{
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        int i = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length)
        {
        	if (stack.isEmpty() || h[i] >= h[stack.peek()])
        		stack.push(i++);
        	else
        	{
        		int t = stack.pop();
        		//if stack is empty,
        		//it means that the index just popped out has the smallest height
        		//in the indices that have been seen except i
        		area = Math.max(area, h[t]*((stack.isEmpty())? i:i-stack.peek()-1));
        	}
        }
        return area;
    }
    public static void main(String[] args)
	{
		int[] height = {2,1,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
}
