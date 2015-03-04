import java.util.ArrayList;


public class TextJustification
{
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        int count = 0;
        int spaces = 0;
        for (String s: words)
        {
            if (count+s.length() + spaces <= L)
            {
                temp.add(s);
                count += s.length();
                spaces++;
            }
            else
            {
                int extraSpace = L-count-spaces+1;
                for (int i = 0; i < temp.size(); i++)
                {
                    str.append(temp.get(i));
                    if (temp.size() == 1)
                        for (int j = 0; j < L-count; j++)
                            str.append(" ");
                    else 
                    {
                        if (i < extraSpace%(spaces-1))
                            for (int j = 0; j < extraSpace/(spaces-1)+2;j++)
                                str.append(" ");
                        else if (i != temp.size()-1)
                            for (int j= 0; j < extraSpace/(spaces-1)+1;j++)
                                str.append(" ");
                    }
                }
                res.add(str.toString());
                temp.clear();
                temp.add(s);
                str = new StringBuilder();
                count = s.length();
                spaces = 1;
            }
        }
        for (int i = 0; i < temp.size(); i++)
        {
        	if (i == temp.size()-1) str.append(temp.get(i));
        	else
        	{
        		str.append(temp.get(i));
        		str.append(" ");
        	}
        }
        while (str.length() < L)
        	str.append(" ");
        res.add(str.toString());
        return res;
    }
    public static void main(String[] args)
	{
		String[] s = {"This", "is", "an", "example", "ofasdrt", "text", "justification.", "hasdar"};
		for (String sub:fullJustify(s,25))
		System.out.println(sub);
	}
}
