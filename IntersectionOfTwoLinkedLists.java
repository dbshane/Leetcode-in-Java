
public class IntersectionOfTwoLinkedLists
{
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (headA.next != null) headA = headA.next;
        while (headB.next != null) headB = headB.next;
        if (headA != headB) return null;
        headB.next = b;
        ListNode slow = a, fast = a;
        while (true)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        slow = a;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        headB.next = null;
        return slow; 
    }
    public static void main(String[] args)
	{
    	ListNode a10 = new ListNode(8);

    	ListNode a9 = new ListNode(2, a10);
    	ListNode a8 = new ListNode(3, a9);
    	ListNode a7 = new ListNode(4, a8);
    	ListNode a6 = new ListNode(5, a7);
    	
    	ListNode a5 = new ListNode(6, a6);
    	ListNode a4 = new ListNode(7, a7);
    	
    	ListNode a3 = new ListNode(8, a4);
    	ListNode aa = getIntersectionNode(a3,a5);
    	System.out.println(aa.val);
	}
}
