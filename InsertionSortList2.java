
public class InsertionSortList2
{
    public static ListNode insertionSortList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode prehead = new ListNode(0), curr = head.next, pre = head;
    	prehead.next = head;
    	while (curr != null)
    	{
    		ListNode p = prehead; 
    		while (p.next.val < curr.val)
    			p = p.next;
    		if (p.next != curr)
    		{
    			ListNode temp = curr.next;
    			curr.next = p.next;
    			p.next = curr;
    			pre.next = temp;
    			curr = temp;
    		}
    		else
    		{
    			pre = curr;
    			curr = curr.next;
    		}
    	}
    	return prehead.next;
    }
    
    public static void main(String[] args)
	{
    	ListNode a10 = new ListNode(8);

    	ListNode a9 = new ListNode(2, a10);
    	ListNode a8 = new ListNode(3, a9);
    	ListNode a7 = new ListNode(4, a8);
    	ListNode a6 = new ListNode(5, a7);
    	
    	ListNode a5 = new ListNode(6, a6);
    	ListNode a4 = new ListNode(7, a5);
    	
    	ListNode a3 = new ListNode(8, a4);
    	ListNode aa = insertionSortList(a3);
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
