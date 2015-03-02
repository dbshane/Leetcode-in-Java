
public class MinimumPathSum
{
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[h][w];
        for (int i = 0; i<h; i++)
            for (int j = 0; j < w; j++)
            {
                if (i == 0) dp[i][j] = grid[i][j] + dp[i][j-1];
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i-1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        return dp[h-1][w-1];
    }
}
