import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;


public class WordLadder
{
    public static int ladderLength(String start, String end, Set<String> dict) {
    	ArrayList<String> sDict = new ArrayList<String>();
    	sDict.add(start);
    	sDict.addAll(dict);
    	sDict.add(end);
    	int length = sDict.size();
    	int l = sDict.get(0).length();
    	ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[sDict.size()];
    	for (int i = 0; i < sDict.size(); i++)
    		a[i] = new ArrayList<Integer>();
    	for (int i = 0; i < sDict.size(); i++)
    		for (int j = i+1; j < sDict.size(); j++)
    		{
    			int count = 0;
    			for (int k = 0; k < l; k++)
    			{
    				if (sDict.get(i).charAt(k) != sDict.get(j).charAt(k)) count++;
    				if (count > 1) break;
    			}
    			if (count == 1)
    			{
    				a[i].add(j);
    				a[j].add(i);
    			}
    		}
    	boolean[] marked = new boolean[length];
    	int[] distTo = new int[length];
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	queue.offer(0);
    	marked[0] = true;
    	distTo[0] = 1;
    	while (!queue.isEmpty())
    	{
    		int temp = queue.poll();
    		for (int i: a[temp])
    		{
    			if (!marked[i])
    			{
    				distTo[i] = distTo[temp]+1;
    				queue.offer(i);
    				marked[i] = true;
    			}
    		}
    	}
    	return distTo[length-1];
    }
    
    public static void main(String[] args)
	{
		Set<String> a = new HashSet<String>();
		a.add("hot");
		a.add("dot");
		a.add("dog");
		a.add("lot");
		a.add("log");
		System.out.println(ladderLength("hit","cog", a));
	}
}
