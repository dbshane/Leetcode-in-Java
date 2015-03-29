
public class LinkedListCycle
{
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
   }
    public static void main(String[] args)
	{
    	ListNode a10 = new ListNode(8);

    	ListNode a9 = new ListNode(7, a10);
    	ListNode a8 = new ListNode(6, a9);
    	ListNode a7 = new ListNode(5, a8);
    	ListNode a6 = new ListNode(4, a7);
    	
    	ListNode a5 = new ListNode(3, a6);
    	ListNode a4 = new ListNode(2, a5);
    	
    	ListNode a3 = new ListNode(1, a4);
    	System.out.println(hasCycle(a3));
	}
}
