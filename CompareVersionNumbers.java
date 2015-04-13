
public class CompareVersionNumbers
{
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++)
        {
            int a = i < v1.length?Integer.parseInt(v1[i]):0;
            int b = i < v2.length?Integer.parseInt(v2[i]):0;
            if (a > b) return 1;
            if (b > a) return -1;
        }
        return 0;
    }

    public static void main(String[] args)
	{
		System.out.println(compareVersion("1.00", "1"));
	}
}
