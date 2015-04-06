import java.util.ArrayList;


public class InsertionSortList //Standard Insertion Sort and have to use an array to get prev elements
{
    public static ListNode insertionSortList(ListNode head) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode p = head;
        ArrayList<ListNode> array = new ArrayList<ListNode>();
        while (p != null)
        {
            array.add(p);
            p = p.next;
        }
        p = head;
        for (int i = 1; i < array.size(); i++)
        {
            ListNode curr = array.get(i);
            int j = i-1;
            while (j >= 0 && array.get(j).val > curr.val)
            {
                array.set(j+1, array.get(j));
                j--;
            }
            if (j == i-1) continue;
            else
            {
                array.set(j+1, curr);
            	ListNode pre = ((j == -1)?prehead:array.get(j));
            	array.get(i).next = curr.next;
            	curr.next = pre.next;
            	pre.next = curr;
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
