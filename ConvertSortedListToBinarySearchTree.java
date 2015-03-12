
public class ConvertSortedListToBinarySearchTree
{
    public static TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode headCopy = head;
        while (headCopy != null)
        {
            count++;
            headCopy = headCopy.next;
        }
        ListNode[] node = new ListNode[1];  //using an array as the param is because the param it self can't be changed by the method
        node[0] = head;
        return helper(node, 0, count-1);
    }
    
    private static TreeNode helper(ListNode[] node, int lo, int hi)
    {
        if (lo > hi) return null;
        int mid = (lo+hi)/2;
        TreeNode left = helper(node,lo, mid-1);
        TreeNode root = new TreeNode(node[0].val);
        node[0] = node[0].next;   // using an array can change the node to the next one and pass to next call
        TreeNode right = helper(node, mid+1, hi);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String[] args)
	{
		ListNode a = new ListNode(0);
		System.out.println(sortedListToBST(a).val);
	}
}
