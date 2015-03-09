
public class PartitionList
{
    public static ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode curr = res;
        ListNode r = null;
        while (curr.next != null)
        {
            if (curr.next.val < x)
                curr = curr.next;
            else
            {
                if (r == null) r = curr.next;
                if (r.next == null) return res.next;
                while (r.next.val >= x)
                {
                   r = r.next;
                   if (r.next == null) return res.next;
                }
                ListNode temp = curr.next;
                curr.next = r.next;
                r.next = r.next.next;
                curr.next.next = temp;
                curr = curr.next;
            }
        }
        return res.next;
    }
    public static void main(String[] args)
	{
    	ListNode a5 = new ListNode(1);
    	ListNode a4 = new ListNode(2, a5);
    	
    	ListNode a3 = new ListNode(3, a4);
    	
    	
    	
    	/*	ListNode a2 = new ListNode(9, a3);
    	ListNode a1 = new ListNode(1,a2);
    	ListNode a11 = new ListNode(9);*/
    	ListNode aa = partition(a3,3);
    	System.out.println(aa.val);
    	System.out.println(aa.next.val);
    	System.out.println(aa.next.next.val);
	}
}
