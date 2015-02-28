public class RemoveElement
{
	public static int removeElement(int[] A, int elem)
	{
		int l = 0;
		int r = A.length - 1;
		while (l < r)
		{
			if (A[l] != elem)
				l++;
			else
			{
				A[l] = A[r];
				r--;
			}
		}
		if (A[r] == elem)
		{
			r--;
		}
		return r + 1;
	}
    public static void main(String[] args)
	{
		int[] A = {1,1,1,1,1};
		System.out.println(removeElement(A, 1));
		for(int i = 0; i < A.length; i++)
		{
			System.out.println(A[i]);
		}
	}
}
