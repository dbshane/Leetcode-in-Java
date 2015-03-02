
public class UniquePathsII
{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        System.out.println("height " + height + " width " + width);
        int[][] table = new int[height][width];
        int fill = 1;
        for (int i = 0; i < width; i++)
        {
            if (obstacleGrid[0][i] == 0)
                table[0][i] = fill;
            else {
                fill = 0;
                table[0][i] = fill;
            }
        }
        fill = 1;
        for (int i = 0; i < height; i++)
        {
            if (obstacleGrid[i][0] == 0)
                table[i][0] = fill;
            else {
                fill = 0;
                table[i][0] = fill;
            }
        }
        for (int i = 1; i < height; i++)
        {
            for (int j = 1; j < width; j++)
            {
                if (obstacleGrid[i][j] == 1) table[i][j] = 0;
                else table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }
        return table[height-1][width-1]; 
    }
    public static void main(String[] args)
	{
		int[][] a = new int[2][1];
		a[0][0] = 0;
		a[1][0] = 1;
		System.out.println(uniquePathsWithObstacles(a));
	}
}
