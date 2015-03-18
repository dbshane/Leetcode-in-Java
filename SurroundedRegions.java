
public class SurroundedRegions
{
    public static void solve(char[][] board) {
        int h = board.length;
        if (h == 0) return;
        int w = board[0].length;
        int[] num = new int[h*w+1];
        int[] size = new int[h*w+1];
        for (int i = 0; i < h*w+1; i++)
        {
            num[i] = i;
            size[i] = 1;
        }
        for (int i = 1; i < h*w+1; i++)
        {
            int y = (i-1)/w;
            int x = (i-1)%w;
            if (board[y][x] == 'O')
            {
            	if (x-1 >= 0 && board[y][x-1] == 'O')
            		union(i,i-1,num,size);
            	if (y-1 >= 0 && board[y-1][x] == 'O')
            		union(i,i-w,num,size);
            	if (x == 0 || y == 0 || x == w-1 || y == h-1)
            		union(i,0,num,size);
            }
        }
        for (int i = 1; i < h*w+1; i++)
        {
        	
            int y = (i-1)/w;
            int x = (i-1)%w;
            if (board[y][x] == 'O' && root(i, num, size) != root(0, num, size)) board[y][x] = 'X';
        }
    }
    
    private static int root(int p, int[] num, int[] size)
    {
        while (num[p] != p)
        {
            num[p] = num[num[p]];
            p = num[p];
        }
        return p;
    }
    
    private static void union(int p, int q, int[] num, int[] size)
    {
        int rootP = root(p, num, size);
        int rootQ = root(q, num, size);
        if (size[rootP] > size[rootQ])
        {
            num[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        else
        {
            num[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
    
    public static void main(String[] args)
	{
		char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}
