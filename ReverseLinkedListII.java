
public class ReverseLinkedListII
{
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        for (int i = 1; i < m; i++)
            pre = pre.next;
        ListNode end = pre.next;
        ListNode curr = pre.next.next;
        for (int i = 0; i < n-m; i++)
        {
        	ListNode temp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            end.next = temp;
            curr = temp;
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
    	ListNode aa = reverseBetween(a3,1,2);
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
