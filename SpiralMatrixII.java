
public class SpiralMatrixII
{
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, right = n-1, down = n-1, left = 0;
        int count = 0;
        while (up < down && left < right)
        {
            for (int i = left; i < right; i++)
            {
                res[up][i] = count+1;
                count++;
            }
            for (int i = up; i < down; i++)
            {
                res[i][right] = count+1;
                count++;
            }
            for (int i = right; i > left; i--)
            {
                res[down][i] = count+1;
                count++;
            }
            for (int i = down; i> up; i--)
            {
                res[i][left] = count+1;
                count++;
            }
            up++;
            right--;
            down--;
            left++;
        }
        if (n%2 == 1)
            for (int i = left; i <= right; i++)
            {
                res[up][i] = count+1;
                count++;
            }
        return res;
    }
    public static void main(String[] args)
	{
    	int n = 5;
    	int[][] a = generateMatrix(n);
    	
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
}
