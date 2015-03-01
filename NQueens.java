import java.util.ArrayList;

public class NQueens
{
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        char[][] temp = new char[n][n];
        boolean[][] boo = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
            {
                temp[i][j] = '.';
                boo[i][j] = false;
            }
        solve(0, temp, boo, res, n);
        return res;
    }
    
    private static void solve(int start, char[][] temp, boolean[][] boo, ArrayList<String[]> res, int n)
    {
        if (start == n)
        {
            String[] solution = new String[n];
            for (int i = 0; i < n; i++)
                solution[i] = new String(temp[i]);
            res.add(solution);
            return;
        }
        for (int i = 0; i < n; i++)
        {
            if (!boo[start][i])
            {
                boolean[][] alreadyTrue = new boolean[n][n];
                temp[start][i] = 'Q';
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
                solve(start+1, temp, boo, res, n);
                temp[start][i] = '.';
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
    }
    public static void main(String[] args)
	{
		System.out.println(solveNQueens(4).size());
	}
}
