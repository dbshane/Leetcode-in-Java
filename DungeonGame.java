
public class DungeonGame
{
    public static int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length;
        if (h == 0) return 0;
        int w = dungeon[0].length;
        int[][] dp = new int[h][w];
        dp[h-1][w-1] = dungeon[h-1][w-1]>=0?1:0-dungeon[h-1][w-1]+1;
        for (int i = h-2; i >= 0; i --)
            dp[i][w-1] = Math.max(dp[i+1][w-1]-dungeon[i][w-1],1);
        for (int i = w-2; i >= 0; i --)
            dp[h-1][i] = Math.max(dp[h-1][i+1]-dungeon[h-1][i],1);
        for (int i = h-2; i >= 0; i--)
            for (int j = w-2; j >= 0; j--)
                dp[i][j] = Math.min(Math.max(dp[i][j+1]-dungeon[i][j],1),Math.max(dp[i+1][j]-dungeon[i][j],1));
        return dp[0][0];
    }
    
    public static void main(String[] args)
	{
		int[][] a = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(calculateMinimumHP(a));
	}
}
