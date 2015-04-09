
public class SortList
{
    public static ListNode sortList(ListNode head) {
        ListNode prehead = new ListNode(0), slow, fast;
        prehead.next= head;
        int count = 0;
        while (head!= null)
        {
        	count++;
        	head = head.next;
        }
        int k;
        for (int i = 1; i < count; i *= 2)
        {
        	head = slow = fast = prehead;
        	k = 0;
        	while (true)
        	{
        		 slow = slow.next;
        		 fast = fast.next.next;
        		 k++;
        		 System.out.println(k);
        		 if (fast == null || fast.next == null)
        		 {
        			 if (k > i)
        			 {
        				 merge(head, slow, k);
        			 }
        			 break;
        		 }
        		 if (k == i)
        		 {
        			 head = slow = fast = merge(head, slow, k);
        			 k = 0;
        		 }
        		 
        	}
        }
        return prehead.next;
    }
    
    private static ListNode merge(ListNode head, ListNode half, int k)
    {
    	
    	int l = 0, r = 0;
    	ListNode curr = head;
    	while (true)
    	{
    		if ( l < k && (r == k || half.next == null || head.next.val < half.next.val))
    		{
    			curr.next = head.next;
    			head = head.next;
    			l++;
    			curr = curr.next;
    		}
    		else if ( r < k && (l == k || half.next.val < head.next.val))
    		{
    			curr.next = half.next;
    			half = half.next;
    			r++;
    			curr = curr.next;
    		}
    		else break;
    	}
    	return curr;
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
    	ListNode aa = sortList(a3);
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
