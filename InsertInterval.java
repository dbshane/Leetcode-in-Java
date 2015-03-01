import java.util.ArrayList;

public class InsertInterval
{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	// great algorithm, the whole point is only when the intervals overlap with newinterval are combined in "temp"
    	
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