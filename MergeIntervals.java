import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals
{

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals)
	{
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0 || intervals == null)
			return res;
		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval a, Interval b)
			{
				return a.start - b.start;
			}
		});
		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			int resStart = res.get(res.size() - 1).start;
			int resEnd = res.get(res.size() - 1).end;
			if (intervals.get(i).start > resEnd)
				res.add(intervals.get(i));
			else
				res.set(res.size() - 1,
						new Interval(resStart, Math.max(intervals.get(i).end,
								resEnd)));
		}
		return res;
	}
}

class Interval
{
	int start;
	int end;

	Interval()
	{
		start = 0;
		end = 0;
	}

	Interval(int s, int e)
	{
		start = s;
		end = e;
	}
}
