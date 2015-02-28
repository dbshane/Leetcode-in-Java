public class SudokuSolver
{
	public void solveSudoku(char[][] board)
	{
		boolean[][] boorow = new boolean[9][9];
		boolean[][] boocol = new boolean[9][9];
		boolean[][] boobox = new boolean[9][9];
		// initialize the boolean arrays
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
			{
				if (board[i][j] != '.')
				{
					boorow[i][(int) board[i][j] - '1'] = true;
					boocol[j][(int) board[i][j] - '1'] = true;
					boobox[i / 3 + (j / 3) * 3][board[i][j] - '1'] = true;
				}
			}
		System.out.println(solveSudoku(board, boorow, boocol, boobox, 0));
	}

	private boolean solveSudoku(char[][] board, boolean[][] boorow,
			boolean[][] boocol, boolean[][] boobox, int n)
	{
		if (n == 81) return true;
		int i = n / 9, j = n % 9;
		if (board[i][j] != '.') return solveSudoku(board, boorow, boocol, boobox, n+1);
		for (int k = 0; k < 9; k++)
		{
			board[i][j] = (char) (k + '1');
			if (isValidInRow(board, boorow, i, j)
					&& isValidInColumn(board, boocol, i, j)
					&& isValidInBox(board, boobox, i, j))
			{
				boorow[i][k] = true;
				boocol[j][k] = true;
				boobox[i / 3 + (j / 3) * 3][k] = true;
				if (solveSudoku(board, boorow, boocol, boobox, n + 1))
					return true;
				else
				{
					boorow[i][k] = false;
					boocol[j][k] = false;
					boobox[i / 3 + (j / 3) * 3][k] = false;
				}
			}
			board[i][j] = '.';
		}
		return false;
	}

	private boolean isValidInRow(char[][] board, boolean[][] boorow, int i,
			int j)
	{
		if (boorow[i][(int) board[i][j] - '1'] == true)
			return false;
		return true;
	}

	private boolean isValidInColumn(char[][] board, boolean[][] boocol, int i,
			int j)
	{
		if (boocol[j][(int) board[i][j] - '1'] == true)
			return false;
		return true;
	}

	private boolean isValidInBox(char[][] board, boolean[][] boobox, int i,
			int j)
	{
		if (boobox[i / 3 + (j / 3) * 3][board[i][j] - '1'] == true)
			return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		SudokuSolver a = new SudokuSolver();
		String boardArray = "..9748...7.........2.1.9.....7...24..64.1.59..98...3.....8.3.2.........6...2759..";
		char[][] board = new char[9][9];
		for (int i = 0; i<9; i++)
			for(int j = 0; j < 9; j++)
				board[i][j] = boardArray.charAt(i*9+j);
		a.solveSudoku(board);
		for (int i = 0; i<9; i++)
		{
			System.out.println();
			for(int j = 0; j < 9; j++)
				System.out.print(board[i][j]);
		}
				
	}
}
