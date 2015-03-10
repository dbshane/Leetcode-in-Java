
public class RemoveDuplicatesFromSortedListII
{
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode lp = res;
        ListNode rp = head;
        while (rp != null)
        {
            if (rp.next != null && rp.val == rp.next.val)
            {
                while (rp.next != null && rp.val == rp.next.val)
                    rp = rp.next;
                rp = rp.next;
                if (rp == null) lp.next = rp;
            }
            else
            {
                lp.next = rp;
                lp = lp.next;
                rp = rp.next;
            }
        }
        return res.next;
    }
	
	public static void main(String[] args)
	{
		ListNode a10 = new ListNode(8);

		ListNode a9 = new ListNode(7, a10);
		ListNode a8 = new ListNode(6, a9);
		ListNode a7 = new ListNode(2, a8);
		ListNode a6 = new ListNode(2, a7);
		
		ListNode a5 = new ListNode(1, a6);
		ListNode a4 = new ListNode(2, a5);
		
		ListNode a3 = new ListNode(2, a4);
		
		
		
		/*	ListNode a2 = new ListNode(9, a3);
		ListNode a1 = new ListNode(1,a2);
		ListNode a11 = new ListNode(9);*/
		ListNode aa = deleteDuplicates(a3);
		System.out.println(aa.val);
    	System.out.println(aa.next.val);
    	System.out.println(aa.next.next.val);
	}
}
