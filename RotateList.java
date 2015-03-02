
public class RotateList
{
    public static ListNode rotateRight(ListNode head, int n) {
    	if (head == null || head.next == null)   return head;
        ListNode node = head;
        int count = 1;
        while (node.next != null)
        {
            count++;
            node = node.next;
        }
        node.next = head;
        for (int i = 0; i < count-n%count; i++)
            node = node.next;
        head = node.next;
        node.next = null;
        return head;
    }
    public static void main(String[] args)
	{
    	// my ListNode class has a constructor --ListNode(int val, ListNode listNode)
    	ListNode a9 = new ListNode(9);
    	ListNode a8 = new ListNode(8, a9);
    	ListNode a7 = new ListNode(7, a8);
    	ListNode a6 = new ListNode(6, a7);
    	ListNode a5 = new ListNode(5, a6);
    	ListNode a4 = new ListNode(4, a5);
    	ListNode a3 = new ListNode(3, a4);
    	ListNode a2 = new ListNode(2, a3);
    	ListNode a1 = new ListNode(1,a2);
    	System.out.println(rotateRight(a1,5).val);
	}
}
