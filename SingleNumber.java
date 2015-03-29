
public class SingleNumber
{
	// property: a ^ b = b ^ a;
	//          (a ^ b) ^ c = a ^ (b ^ c)
	//           a ^ a = 0
	//           b ^ a ^ a = b
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i: A)
            x = x ^ i;
        return x;
    }
}
