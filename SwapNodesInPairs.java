
public class SwapNodesInPairs
{
    public static ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res;
        ListNode temp = null;
        while (p.next != null && p.next.next != null)
        {
            temp = p.next;
            p.next = p.next.next;
            temp.next = p.next.next;
            p.next.next = temp;
            p = p.next.next;
        }
        return res.next;
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
    	
    	
    	
    	/*	ListNode a2 = new ListNode(9, a3);
    	ListNode a1 = new ListNode(1,a2);
    	ListNode a11 = new ListNode(9);*/
    	ListNode aa = swapPairs(a3);
    	System.out.println(aa.val);
    	System.out.println(aa.next.val);
    	System.out.println(aa.next.next.val);
    	System.out.println(aa.next.next.next.val);
    	System.out.println(aa.next.next.next.next.val);
    	System.out.println(aa.next.next.next.next.next.val);
    	System.out.println(aa.next.next.next.next.next.next.val);
    	System.out.println(aa.next.next.next.next.next.next.next.val);
    	
	}
}
