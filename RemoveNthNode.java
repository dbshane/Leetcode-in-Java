
public class RemoveNthNode
{
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        ListNode r = head;
        for (int i = 0; i < n ; i++)
        {
            if(r.next == null) return head.next;
            r = r.next;
        }
        while (r.next != null)
        {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return head;
    }
    public static void main(String[] args)
	{

    	ListNode a9 = new ListNode(2);
    	ListNode a8 = new ListNode(1, a9);
    /*	ListNode a7 = new ListNode(9, a8);
    	ListNode a6 = new ListNode(9, a7);
    	
    	ListNode a5 = new ListNode(9, a6);
    	ListNode a4 = new ListNode(9, a5);
    	
    	ListNode a3 = new ListNode(9, a4);
    	
    	
    	
    	ListNode a2 = new ListNode(9, a3);
    	ListNode a1 = new ListNode(1,a2);
    	ListNode a11 = new ListNode(9);*/
    	System.out.println(removeNthFromEnd(a8,2).val);
	}
}
