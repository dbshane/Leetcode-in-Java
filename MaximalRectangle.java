import java.util.Stack;


public class MaximalRectangle
{
    public static int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0) return 0;
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < matrix.length; i++)
        {
            int[] height = new int[matrix[0].length+1];
            for (int j = 0; j < matrix[0].length; j++)
            {
                int count = 0;
                while (i >= count && matrix[i-count][j] == '1') count++;
                height[j] = count;
            }
            int j = 0;
            while (j < height.length)
            {
                if (stack.isEmpty()|| height[j] >= height[stack.peek()])
                    stack.push(j++);
                else
                {
                    int curr = stack.pop();
                    area = Math.max(area, height[curr]*(stack.isEmpty()?j:j-stack.peek()-1));
                }
            }
            stack.clear();
        }
        return area;
    }
    public static void main(String[] args)
	{
		char[][] a = {{'1','0'},{'1','0'}};
		System.out.println(maximalRectangle(a));
	}
}
