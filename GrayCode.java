import java.util.ArrayList;

/*
	the list is symmetric in spite of the most left digit
	
	0 00
	0 01
	0 11
	0 10
	1 10
	1 11
	1 01
	1 00
	
	So every time get all integers from the list in reverse order and add 1 to left side
*/
public class GrayCode
{
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0) return res;
        res.add(1);
        if (n == 1) return res;
        for (int i = 1; i < n; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>(); //Make a temporary list
            for (int j = res.size()-1; j >= 0; j--) //Get all numbers from result list
                temp.add(res.get(j)+(1<<i));		//in reverse order and add "1" to left
            for (int j: temp)			//Add all integers in temporary list to result list
                res.add(j);
        }
        return res;
    }
    public static void main(String[] args)
	{
		System.out.println(grayCode(2));
	}
}
