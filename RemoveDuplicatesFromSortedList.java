
public class RemoveDuplicatesFromSortedList
{
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode lp = head;
        ListNode rp = head.next;
        while (rp != null)
        {
            if (rp.val != lp.val)
            {
                lp.next = rp;
                rp = rp.next;
                lp = lp.next;
            }
            else
            {
            	rp = rp.next;
            	if (rp == null) lp.next = null;
            }
        }
        return head;
    }
    public static void main(String[] args)
	{
    	ListNode a10 = new ListNode(8);

    	ListNode a9 = new ListNode(8, a10);
    	ListNode a8 = new ListNode(7, a9);
    	ListNode a7 = new ListNode(5, a8);
    	ListNode a6 = new ListNode(5, a7);
    	
    	ListNode a5 = new ListNode(3, a6);
    	ListNode a4 = new ListNode(1, a5);
    	
    	ListNode a3 = new ListNode(1, a4);
    	
    	
    	
    	/*	ListNode a2 = new ListNode(9, a3);
    	ListNode a1 = new ListNode(1,a2);
    	ListNode a11 = new ListNode(9);*/
    	ListNode aa = deleteDuplicates(a3);
    	System.out.println(aa.val);
    	System.out.println(aa.next.val);
    	System.out.println(aa.next.next.val);
    	System.out.println(aa.next.next.next.val);
    	System.out.println(aa.next.next.next.next.val);
    	
	}
}
