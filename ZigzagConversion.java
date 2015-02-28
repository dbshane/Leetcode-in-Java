public class ZigzagConversion {
    public String convert(String s, int nRows) {
    	if (nRows == 1) return s;
        int length = s.length();
        
        char[][] zigzag = new char[length/2 + 1][nRows];
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++)
        {
            zigzag[y][x] = s.charAt(i);
            if (y % (nRows - 1) != 0 || x == nRows - 1)
            {
            	x--;
            	y++;
            }
            else
            {
            	x++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++)
        {
            for (int j = 0; j < length/2 + 1; j++)
            {
                if (zigzag[j][i] != '\u0000')
                sb.append(zigzag[j][i]);
            }
        }
        String result = sb.toString();
        return result;
    }
    
    public static void main(String[] args)
    {
    	ZigzagConversion a = new ZigzagConversion();
    	System.out.println(a.convert("ab°¢ÈøµÂ·É", 2));
    }
}

