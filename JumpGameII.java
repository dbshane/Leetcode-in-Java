import java.util.LinkedList;


public class JumpGameII
{
    public static int jump(int[] A) {
        if (A.length == 0 || A.length == 1) return 0;
        int[] edgeTo = new int[A.length];
        int[] distTo = new int[A.length];
        boolean[] marked = new boolean[A.length];
        for (int i = 0; i < A.length; i++)  marked[i] = false;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty())
        {
            int temp = queue.poll();
            for (int i = A[temp]; i >= 0; i--)
            {
                if (temp + i < A.length && !marked[temp+i])
                {
                    edgeTo[temp+i] = temp;
                    queue.offer(temp+i);
                    distTo[temp+i] = distTo[temp]+1;
                    marked[temp+i] = true;
                    if (temp + i == A.length-1)  return distTo[temp+i];
                }
            }
        }
        return distTo[A.length-1];
    }
    public static void main(String[] args)
	{ 
    	int[] a = new int[25000];
    	for (int i = 0; i < a.length; i++)
    		a[i] = 25000 - i;
		System.out.println(jump(a));
	}
}
