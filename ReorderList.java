
public class ReorderList
{
    public static void reorderList(ListNode head) {
    	if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        //find the half
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        if (curr == null) return;
        //reverse the second 
        ListNode temp;
        while (curr.next != null)
        {
            temp = slow.next;
            slow.next = curr.next;
            curr.next = slow.next.next;
            slow.next.next = temp;
        }
        // merge two halves
        ListNode half = slow.next;
        slow.next = null;
        curr = head;
        while (half != null)
        {
            temp = half.next;
            half.next = curr.next;
            curr.next = half;
            curr = half.next;
            half = temp;
        }
    }
    public static void main(String[] args)
	{
    	ListNode a5 = new ListNode(3);
    	ListNode a4 = new ListNode(2, a5);
    	
    	ListNode a3 = new ListNode(1, a4);
    	reorderList(a3);
    	System.out.println(a3.val);
    	System.out.println(a3.next.val);
    	System.out.println(a3.next.next.val);
	}
}
