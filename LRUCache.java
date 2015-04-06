import java.util.HashMap;

public class LRUCache
{
    private HashMap<Integer, DoubleLinkedListNode> map;
    private DoubleLinkedListNode head, end;
    private int capacity;
    private int size = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedListNode(0, 0);
        end = head;
        map = new HashMap<Integer, DoubleLinkedListNode>();
        map.put(0, head);
    }
    
    public int get(int key) {
    	if (map.containsKey(key))
    	{
    		DoubleLinkedListNode temp = map.get(key);
    		moveToEnd(temp);
    		if (temp.val > 0)
    		    return temp.val;
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key))
    	{
    		DoubleLinkedListNode temp = map.get(key);
    		moveToEnd(temp);
    		temp.val = value;
    		return;
    	}
    	if (size == capacity)  // Remove the first element (fake head's next)
    	{
    	    DoubleLinkedListNode temp = head.next;
    	    head.next = head.next.next;
    	    if (head.next == null)
    		    end = head;
    	    else
    		    head.next.prev = head;
    	    map.remove(temp.key);
    	    size--;
    	}
        end.next = new DoubleLinkedListNode(key, value);
        end.next.prev = end;
        end = end.next;
        map.put(key, end);
        size++;
    }
    // Move the recently called to the end
    private void moveToEnd(DoubleLinkedListNode node)
    {
    	if (node == end) return;
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    	node.prev = end;
    	node.next = null;
    	end.next = node;
    	end = node;
    }
    
    public static void main(String[] args)
    {
    	LRUCache a = new LRUCache(1);
    	System.out.println(a.get(0));
    }
}

class DoubleLinkedListNode
{
	DoubleLinkedListNode prev;
	DoubleLinkedListNode next;
	int key;
	int val;
	
	DoubleLinkedListNode(int key, int val)
	{
		this.key = key;
		this.val = val;
	}
}