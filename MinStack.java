import java.util.ArrayList;


class MinStack
{
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ArrayList<Integer> minList = new ArrayList<Integer>();
    
    public MinStack()
    {
        minList.add(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        minList.add(x < minList.get(minList.size()-1)?x:minList.get(minList.size()-1));
        list.add(x);
    }

    public void pop() {
        if (!list.isEmpty())
        {
            list.remove(list.size()-1);
            minList.remove(minList.size()-1);
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return minList.get(minList.size()-1);
    }
    
    public static void main(String[] args)
	{
		MinStack stack = new MinStack();
		stack.push(3);
		stack.pop();
		stack.push(20);
		System.out.println(stack.getMin());
	}
}
