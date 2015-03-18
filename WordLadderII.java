import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadderII
{
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) 
    {
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	ArrayList<String> sDict = new ArrayList<String>();
    	sDict.add(start);
    	sDict.addAll(dict);
    	sDict.add(end);
    	int length = sDict.size();
    	if (length == 0) return res;
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
    	ArrayList<Integer>[] edgeTo = (ArrayList<Integer>[]) new ArrayList[length];
    	for (int i = 0; i < length; i++)
    		edgeTo[i] = new ArrayList<Integer>();
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
    				edgeTo[i].add(temp);
    				marked[i] = true;
    			}
    			else if (distTo[i] == distTo[temp]+1)
    				edgeTo[i].add(temp);
    		}
    	}
    	ArrayList<String> al = new ArrayList<String>();
    	al.add(sDict.get(length-1));
    	helper(sDict, edgeTo, length-1, al, res);
    	return res;
    }
    
    private static void helper(ArrayList<String> sDict, ArrayList<Integer>[] edgeTo, 
    					int curr, ArrayList<String> temp, ArrayList<ArrayList<String>> res)
    {
    	if (curr == 0)
    	{
    		ArrayList<String> reverse = new ArrayList<String>();
    		for (int i = temp.size()-1; i >= 0; i--)
    			reverse.add(temp.get(i));
    		res.add(reverse);
    	}
    	for (int i: edgeTo[curr])
    	{
    		temp.add(sDict.get(i));
    		helper(sDict, edgeTo, i, temp, res);
    		temp.remove(temp.size()-1);
    	}
    }
    
    public static void main(String[] args)
	{
		Set<String> a = new HashSet<String>();
		a.add("hot");
		a.add("dot");
		a.add("dog");
		a.add("lot");
		a.add("log");
		System.out.println(findLadders("hit","cog", a));
	}
}
