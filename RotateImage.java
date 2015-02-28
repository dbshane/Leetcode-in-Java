
public class RotateImage
{
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) return;
        int l = matrix.length;
        int temp;
        for (int n = 0; n < l/2; n++)
        {
            for (int i = n; i < l-n-1; i++)		 //make sure i < l-n-1, not i <= l-n-1;
            {
            	temp = matrix[i][n];		//temp = left
            	matrix[i][n] = matrix[l-n-1][i];//left = down
                matrix[l-n-1][i] = matrix[l-i-1][l-n-1];//down = right
            	matrix[l-i-1][l-n-1] = matrix[n][l-i-1];//right = up
                matrix[n][l-i-1] = temp;//up = temp
            }
        }
    }
    public static void main(String[] args)
	{
		int n = 6;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				matrix[i][j] = i+j*10;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		rotate(matrix);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
