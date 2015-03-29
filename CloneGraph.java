import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CloneGraph
{
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return helper(node, map);
    }
    
    private static UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map)
    {
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        ArrayList<UndirectedGraphNode> newList = new ArrayList<UndirectedGraphNode>();
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode n: node.neighbors)
        	newList.add(helper(n, map));
        newNode.neighbors = newList;
        return newNode;
    }
    public static void main(String[] args)
	{
    	UndirectedGraphNode a = new UndirectedGraphNode(-1);
    	a.addNeighbors(new UndirectedGraphNode(1));
    	UndirectedGraphNode b = cloneGraph(a);
    	for (int i = 0; i < b.neighbors.size(); i++)
    		System.out.println(b.neighbors.get(i).label);
	}
}
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) 
	{ 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
	void addNeighbors(UndirectedGraphNode neighbor)
	{
		neighbors.add(neighbor);
	}
}