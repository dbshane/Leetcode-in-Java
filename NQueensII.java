
public class NQueensII
{
    public static int totalNQueens(int n) {
        boolean[][] boo = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                boo[i][j] = false;
        
        int res = solve(0, boo, 0, n);
        return res;
    }
    
    private static int solve(int start, boolean[][] boo, int count, int n)
    {
        if (start == n)
            return count+1;
        for (int i = 0; i < n; i++)
        {
            if (!boo[start][i])
            {
                boolean[][] alreadyTrue = new boolean[n][n];
                for (int j = start+1; j < n; j++)
                {   
                    if (j-start+i >= 0 && j-start+i < n)
                    {
                        if (boo[j][j-start+i]) alreadyTrue[j][j-start+i] = true;
                        boo[j][j-start+i] = true;
                    }
                    if (start+i-j >= 0 && start+i-j < n)
                    {
                        if (boo[j][start+i-j]) alreadyTrue[j][start+i-j] = true;
                        boo[j][start+i-j] = true;
                    }
                    if (boo[j][i])  alreadyTrue[j][i] = true;
                    boo[j][i] = true;
                }
                count = solve(start+1, boo, count, n);
                for (int j = start; j < n; j++)
                {   
                    if (j-start+i >= 0 && j-start+i < n && !alreadyTrue[j][j-start+i])
                        boo[j][j-start+i] = false;
                    if (start+i-j >= 0 && start+i-j < n && !alreadyTrue[j][start+i-j])
                        boo[j][start+i-j] = false;
                    if (!alreadyTrue[j][i])
                        boo[j][i] = false;
                }
            }
        }
        return count;
    }
}
