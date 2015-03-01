import java.util.ArrayList;

public class SpiralMatrixAnotherImplement
{
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    	int m = matrix.length;
    	int n = matrix[0].length;
        int up = 0, right = n-1, down = m-1, left = 0;
        int count = 0;
        int i = 0, j = 0;
        while (count < m*n)
        {
            res.add(matrix[i][j]);
            count++;
            if (i == up && j < right) 
                j++;
            else if (j == right && i < down) 
                i++;
            else if (i == down && j > left)
                j--;
            else
            {
            	if (i == up+1)
            	{
            		j++;
            		up++;
            		left++;
            		right--;
            		down--;
            	}
            	else i--;
            }
        }
        return res;
    }
    public static void main(String[] args)
	{
    	int n = 10;
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
