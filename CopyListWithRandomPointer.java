import java.util.HashMap;


public class CopyListWithRandomPointer
{
	// copy the list first, put the copied one (value) and original one (key) in the map
	// iterate the list again, get the random value from the map
    public static RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode fh = new RandomListNode(0), cp = new RandomListNode(0), curr = new RandomListNode(head.label);
        fh.next = head;
        cp.next = curr;
        map.put(head, curr);
        while (head.next != null)
        {
            curr.next = new RandomListNode(head.next.label);
            head = head.next;
            curr = curr.next;
            map.put(head, curr);
        }
        head = fh.next;
        curr = cp.next;
        while (head != null)
        {
            curr.random = map.get(head.random);
            curr = curr.next;
            head = head.next;
        }
        return cp.next;
    }
    public static void main(String[] args)
	{
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		a.next = b;
		a.random = b;
		RandomListNode e = copyRandomList(a);
		System.out.println(e.next.label);
		
	}
}
class RandomListNode {
   int label;
   RandomListNode next, random;
   RandomListNode(int x) 
   { 
	   this.label = x; 
   }
}