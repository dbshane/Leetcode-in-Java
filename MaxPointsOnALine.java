import java.util.HashMap;


public class MaxPointsOnALine
{
    public static int maxPoints(Point[] points) {
    	if (points.length == 0) return 0;
        int max = 1;
        for (int i = 0; i < points.length; i++)
        {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int base = 1;
            for (int j = 0; j < points.length; j++)
            {
                if (j != i)
                {
                    double slope = slopeTo(points[j], points[i]);
                    if (slope == Double.NEGATIVE_INFINITY) base++;
                    else
                    	map.put(slope, map.containsKey(slope)?map.get(slope)+1:1);
                    if ((map.containsKey(slope)?(map.get(slope)+base):base) > max)
                    	max = map.containsKey(slope)?(map.get(slope)+base):base;
                }
            }
        }
        return max;
    }
    
    private static double slopeTo(Point p1, Point p2)
    {
    	if (p1.x == p2.x && p1.y == p2.y) return Double.NEGATIVE_INFINITY;
        if (p1.x == p2.x) return Double.POSITIVE_INFINITY;
        if (p1.y == p2.y) return 0;
        return (double) (p1.y-p2.y)/(double) (p1.x-p2.x); 
    }
    public static void main(String[] args)
	{
		Point a = new Point(0,0);
		Point b = new Point(0,0);
		Point[] points = new Point[2];
		points[0] = a;
		points[1] = b;
 		System.out.println(maxPoints(points));
	}
}

class Point
{
	int x;
	int y;
	Point(){}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
