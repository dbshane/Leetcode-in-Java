import java.util.ArrayList;


public class InsertInterval
{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> res = new ArrayList<Interval>();
    	Interval temp = newInterval;
    	for (Interval i: intervals)
    	{
    		if (i.end < temp.start)
    		{
    			res.add(i);
    		}
    		else if (i.start > temp.end)
    		{
    			res.add(temp);
    			temp = i;
    		}
    		else
    		{
    			temp = new Interval(Math.min(i.start, temp.start), Math.max(i.end,temp.end));
    		}
    	}
    	res.add(temp);
    	return res;
    }
}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	}