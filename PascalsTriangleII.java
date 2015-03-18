import java.util.ArrayList;

public class PascalsTriangleII
{
	public static ArrayList<Integer> getRow(int numRows)
	{
		ArrayList<Integer> res = new ArrayList<Integer>(numRows+1);
		for (int i = 0; i < numRows+1; i++)
			res.add(0);
		for (int i = 0; i < numRows+1; i++)
		{
			res.set(i, 1);
			for (int j = i-1; j > 0; j--)
				if (j >= 1)
				res.set(j, res.get(j)+res.get(j-1));
		}
		return res;
	}
	public static void main(String[] args)
	{
		System.out.println(getRow(0));
	}
}
