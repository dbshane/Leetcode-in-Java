
public class ReverseNodesInKGroup
{
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res;
        while (testK(p, k))
        {
            p = reverseKNode(p, k);
        }
        return res.next;
    }
    private static ListNode reverseKNode(ListNode p, int k){
        if (k == 1) return p.next;
        ListNode temp = p;
        for (int i = 0; i < k - 1; i++)
            temp = temp.next;
        ListNode temp2 = p.next;
        p.next = temp.next;
        temp.next = temp.next.next;
        p.next.next = temp2;
        return reverseKNode(p.next, k - 1);
    }
    private static boolean testK(ListNode p, int k)
    {
        ListNode temp = p;
        for (int i = 0; i < k; i++)
        {
            if (temp.next == null)
                return false;
            temp = temp.next;
        }
        return true;
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
    	ListNode aa = reverseKGroup(a3,4);
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
