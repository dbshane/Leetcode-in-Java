import java.util.ArrayList;

public class Permutation
{
	public static ArrayList<ArrayList<Integer>> permute(int[] num)
	{
		if (num.length == 0) return null;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		boolean[] used = new boolean[num.length];
		ArrayList<Integer> build = new ArrayList<Integer>();
		permute(num, used, build, res);
		return res;
	}

	private static void permute(int[] num, boolean[] used,
			ArrayList<Integer> build, ArrayList<ArrayList<Integer>> res)
	{
		if (build.size() == num.length)
			res.add(new ArrayList<Integer>(build));
		for (int i = 0; i < num.length; i++)
		{
			if (used[i] == false)
			{
				build.add(num[i]);
				used[i] = true;
				permute(num, used, build, res);
				used[i] = false;
				build.remove(build.size() - 1);
			}
		}
	}
	public static void main(String[] args)
	{
		int[] a = {1,2,3,4,5};
		System.out.println(permute(a));
	}
}
