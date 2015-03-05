
public class WordSearch
{
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board == null) return false;
        int h = board.length;
        int w = board[0].length;
        boolean[][] marked = new boolean[h][w];
        for(int i = 0; i < h; i++)
            for(int j = 0; j < w; j++)
                if(search(board, 0, word, i, j, marked))
                    return true;
        return false;
    }
    
    private static boolean search(char[][] board, int start, String word, int i, int j, boolean[][] marked)
    {
    	int h = board.length;
        int w = board[0].length;
        if (start == word.length()) return true;
        if ( i < 0 || i > h-1 || j < 0 || j > w-1 || marked[i][j] || board[i][j] != word.charAt(start))
            return false;
        else
        {
            marked[i][j] = true;
            if (search(board, start+1, word, i+1, j, marked)) return true;
            if (search(board, start+1, word, i-1, j, marked)) return true;
            if (search(board, start+1, word, i, j+1, marked)) return true;
            if (search(board, start+1, word, i, j-1, marked)) return true;
            marked[i][j] = false;
        }
        return false;
    }
    public static void main(String[] args)
	{
    	char[][] board = {
    			{'A','B', 'C', 'E'},
    			{'S','F', 'C', 'S'},
    			{'A','D', 'E', 'E'}};
		System.out.println(exist(board, "ABCCEED"));
	}
}
