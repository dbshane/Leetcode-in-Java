
public class PopulatingNextRightPointersInEachNodeII
{
    public static void connect(TreeLinkNode root) {
    	connect(root, null);
    }
    
    private static void connect(TreeLinkNode root, TreeLinkNode next)
    {
        if (root == null || (root.left == null && root.right == null)) return;
        while (next!= null && next.left == null && next.right == null)
        	next = next.next;
        if (next != null)
        	next = next.left == null?next.right:next.left;
        if (root.right == null)
            root.left.next = next;
        else
        {
            if (root.left != null)
                root.left.next = root.right;
            root.right.next = next;
        }
        connect(root.right, root.right == null?null:next);
        connect(root.left, root.right == null?next:root.right);
    }
    public static void main(String[] args)
	{
		TreeLinkNode a = new TreeLinkNode(1);
		TreeLinkNode b = new TreeLinkNode(2);
		TreeLinkNode c = new TreeLinkNode(2);
		TreeLinkNode d = new TreeLinkNode(3);
		TreeLinkNode e = new TreeLinkNode(31);
		TreeLinkNode f = new TreeLinkNode(39);
		TreeLinkNode g = new TreeLinkNode(3);
		TreeLinkNode h = new TreeLinkNode(4);
		TreeLinkNode i = new TreeLinkNode(4);
		TreeLinkNode j = new TreeLinkNode(4);
		TreeLinkNode k = new TreeLinkNode(4);
		TreeLinkNode l = new TreeLinkNode(4);
		TreeLinkNode m = new TreeLinkNode(4);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.left = h;
		d.right = i;
		e.left = j;
		e.right = k;
		f.left = l;
		f.right = m;
		connect(a);
		System.out.println(k.next.val);
	}
    
}
