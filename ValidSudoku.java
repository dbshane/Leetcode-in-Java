
public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board) {
        boolean[][] boorow = new boolean[9][9];
        boolean[][] boocol = new boolean[9][9];
        boolean[][] boobox = new boolean[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {   
                    if (!isValidInRow(board, boorow, i, j))  return false;
                    if (!isValidInColumn(board, boocol, i, j))  return false;
                    if (!isValidInBox(board, boobox, i, j))  return false;
                    boorow[i][(int) board[i][j]-'1'] = true;
                    boocol[j][(int) board[i][j]-'1'] = true;
                    boobox[i/3+(j/3)*3][board[i][j]-'1'] = true;
                }
            }
        return true;
    }

    private boolean isValidInRow(char[][] board, boolean[][] boorow, int i, int j)
    {
        if (boorow[i][(int) board[i][j]-'1'] == true) return false;
        return true;
    }
    
    private boolean isValidInColumn(char[][] board, boolean[][] boocol, int i, int j)
    {
        if (boocol[j][(int) board[i][j]-'1'] == true) return false;
        return true;
    }
    
    private boolean isValidInBox(char[][] board, boolean[][] boobox, int i, int j)
    {
        if (boobox[i/3+(j/3)*3][board[i][j]-'1'] == true) return false;
        return true;
    }
}
