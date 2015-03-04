
public class SqrtX
{
    public static int sqrt(int x) {
        if (x == 1 || x == 0) return x;
        double temp = x/2;
        while (Math.abs(temp * temp - x) > 0.0001)
            temp = (temp + x/temp)/2; // Newton's method
        return (int) temp;
    }
    public static void main(String[] args)
	{
		System.out.println(sqrt(9));
	}
}
