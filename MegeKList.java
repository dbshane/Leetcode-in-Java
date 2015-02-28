import java.util.ArrayList;


public class MegeKList
{
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        return mergeK(lists, 0, lists.size());
    }
    
    private static ListNode mergeK(ArrayList<ListNode> lists, int lo, int hi)
    {
        if (lo < hi) 
        {
            int mid = (lo + hi) / 2;
            ListNode a = mergeK(lists, lo, mid);
            ListNode b = mergeK(lists, mid + 1, hi);
            return mergeTwoList(a, b);
        }
        return lists.get(lo);
    }
    
    private static ListNode mergeTwoList(ListNode l1, ListNode l2)
    {
        ListNode res = new ListNode(0);
        ListNode current = res;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                current.next = l1;
                l1 = l1.next;
            }
            else 
            {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) current.next = l2;
        if (l2 == null) current.next = l1;
        return res.next;
    }
}
