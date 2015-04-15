import java.util.ArrayList;
import java.util.HashMap;


public class RepeatedDNASequences
{
	// directly use HashMap for substrings will use too much memory
	// using bit manipulation repeatedly can save memory
    public static ArrayList<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() <= 10) return res;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] binary = new int[26]; // use an array to continently find the binary for each letter
        binary['A'-'A'] = 0;  // set A to 00, C to 01, G to 10, T to 11.
        binary['C'-'A'] = 1;
        binary['G'-'A'] = 2;
        binary['T'-'A'] = 3;
        int number = 0;  // this number will be manipulated repeatedly
        for (int i = 0; i < 10; i++)
        {
        	number <<= 2;  // for example: 100010 will become 10001000
        	number |= binary[s.charAt(i)-'A']; // if is 'T', 10001000 will become 10001011
        }
        map.put(number,1);
        for (int i = 10; i < s.length(); i++)
        {
        	
        	number <<= 2;
        	number |= binary[s.charAt(i)-'A'];
        	number &= (1 << 20)-1;  // (1 << 20) - 1 is 11111111111111111111, zero out the bits before
        	if (map.containsKey(number) && map.get(number) == 1) res.add(s.substring(i-9, i+1));
        	map.put(number, map.containsKey(number)?map.get(number)+1:1);
        }
        return res;
    }
    
    public static void main(String[] args)
	{
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
