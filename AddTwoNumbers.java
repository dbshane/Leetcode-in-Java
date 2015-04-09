/*You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

*Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
*Output: 7 -> 0 -> 8
*/


import java.util.*;

public class AddTwoNumbers
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = reverse(l1) + reverse(l2);
        return reverse2(sum);
    }
    
    private long reverse(ListNode l1)
    {
    	long total = 0;
    	int digit = 0;
    	ListNode current = l1;
    	while (current!= null)
    	{
    		total = current.val * (long) Math.pow(10,digit) + total;
    		digit++;
    		current = current.next;
    	}
    	return total;	
    }
    
    private ListNode reverse2(long x)
    {
    	long remains = x;
    	ArrayList<ListNode> a  = new ArrayList<ListNode>(15);
    	
    	do
    	{
    		a.add(new ListNode((int) (remains % 10)));
    		remains = remains/10;
    	}
    	while (remains > 0);
    	for (int i = 0; i < a.size() - 1; i++)
    	{
    		a.get(i).next = a.get(i+1);
    	}
    	
    	return a.get(0);
    }
    
    public static void main(String[] args)
	{
    	AddTwoNumbers f = new AddTwoNumbers();
    	
    	ListNode a10 = new ListNode(9);
    	ListNode a9 = new ListNode(9, a10);
    	ListNode a8 = new ListNode(9, a9);
    	ListNode a7 = new ListNode(9, a8);
    	ListNode a6 = new ListNode(9, a7);
    	
    	ListNode a5 = new ListNode(9, a6);
    	ListNode a4 = new ListNode(9, a5);
    	
    	ListNode a3 = new ListNode(9, a4);
    	
    	
    	
    	ListNode a2 = new ListNode(9, a3);
    	ListNode a1 = new ListNode(1,a2);
    	ListNode a11 = new ListNode(9);
    	System.out.println("aaa" + f.addTwoNumbers(a1, a11).val);
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode l2) {
        val = x;
        next = l2;
    }
}