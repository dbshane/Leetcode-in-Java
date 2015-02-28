
public class ReverseInteger
{
    public int reverse(int x) {
        if (x == 0) return 0;
        if (x == - (Math.pow(2, 31))) return 0;
        int xcopy = x;
        int o = Math.abs(x);
        int i = 0;
        double r = 0;
        do
        {
            xcopy = xcopy / 10;
            i++;
        }
        while (xcopy != 0);
        while (i > 0)
        {
            r = r + (o % 10) * Math.pow(10, i - 1);
            o = o / 10;
        	i--;
        }
        if (r >= Math.pow(2, 31)) return 0;
        else if (x < 0) return (int) (- r);
        else return (int) r;
    }
	public static void main(String[] args)
	{
		ReverseInteger a = new ReverseInteger();
		System.out.println(a.reverse(-1233));
	}
}
