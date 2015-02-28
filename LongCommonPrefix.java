public class LongCommonPrefix
{
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int p = 0;
        StringBuffer pre = new StringBuffer();
        while(p <= strs[0].length() - 1)
        {
            char ch = strs[0].charAt(p);
            for(int i = 1; i < strs.length; i++)
                if (strs[i].length() < p + 1 || strs[i].charAt(p) != ch)
                     return pre.toString();
            pre.append(ch);
            p++;
        }
        return pre.toString();
    }
    
    public static void main(String[] args)
    {
    	LongCommonPrefix a = new LongCommonPrefix();
    	String[] strs = {"","ab","abc","abcd"};
    	System.out.println(a.longestCommonPrefix(strs));
    }
}
