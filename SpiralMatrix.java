import java.util.ArrayList;


public class SpiralMatrix
{
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    	int m = matrix.length;
    	int n = matrix[0].length;
        int up = 0, right = n-1, down = m-1, left = 0;
        int min = Math.min(m,n);
        while (left < right && up < down)
        {
        	for (int i = left; i < right; i++)
        		res.add(matrix[up][i]);
        	for (int i = up; i < down; i++)
        		res.add(matrix[i][right]);
            for (int i = right; i > left; i--)
            	res.add(matrix[down][i]);
            for (int i = down; i > up; i--)
            	res.add(matrix[i][left]);
            up++;
            left++;
            right--;
            down--;
        }
        if (min%2 == 1)
        {
        	if (min == n)
        		for (int i = up; i <= down;i++)
        			res.add(matrix[i][left]);
        	else
        		for (int i = left; i <= right; i++)
        			res.add(matrix[up][i]);
        }
        return res;
    }
    public static void main(String[] args)
	{
    	int n = 3;
    	int m = 6;
		int[][] a = new int[n][m];
		for (int i = 0;i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				a[i][j] = i*m+j+1;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(spiralOrder(a));
	}
}
