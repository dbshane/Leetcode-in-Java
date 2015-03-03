import java.util.ArrayList;


public class SetMatrixZeros
{
    public static void setZeroes(int[][] matrix) {
    	if (matrix.length == 0) return;
        ArrayList<Integer> zeroRow = new ArrayList<Integer>();
        ArrayList<Integer> zeroCol = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0)
                {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
        for (int i = 0; i < zeroRow.size(); i++)
            for (int j = 0; j < n; j++)
                matrix[zeroRow.get(i)][j] = 0;
        for (int i = 0; i < zeroCol.size(); i++)
            for (int j = 0; j < m; j++)
                matrix[j][zeroCol.get(i)] = 0;
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
				a[i][j] = i*2 - j - 1;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		setZeroes(a);
		for (int i = 0;i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
