import java.util.ArrayList;


public class SimplifyPath
{
    public static String simplifyPath(String path) {
        ArrayList<String> res = new ArrayList<String>();  //for folder names storage
        StringBuilder temp = new StringBuilder();  //build folder name
        for (int i = 1; i < path.length(); i++)
        {
            if (path.charAt(i) == '/')	//whenever see a '/', look at the StringBuilder temp
            {
                if (temp.toString().equals(".."))  
                {
                	if (res.size()!= 0)			// if res has elements, remove the last one, if not, do nothing
                		res.remove(res.size()-1);
                    temp.delete(0,2);		// empty temp
                }
                else if (temp.toString().equals("."))  // just empty temp for '.'
                {
                	temp.delete(0,1);
                }
                else if (temp.length() != 0)  // if temp is not empty, add to res. (If temp is empty, means redundant '/', ignore)
                {
                    res.add(temp.toString());
                    temp.delete(0, temp.length());
                }
            }
            else
                temp.append(path.charAt(i));
        }
        if (temp.length() != 0) 	// in case the last char in the path is not '/'
        {
        	if (temp.toString().equals(".."))
        	{	if (res.size() != 0)
        		res.remove(res.size()-1);
        	}
        	else if (!temp.toString().equals("."))  // only add to res if temp is not '.' or '..'
        		res.add(temp.toString());
        }
        if (res.size() == 0)
            return "/";
        else
        {
            StringBuilder result = new StringBuilder();
            for (String s: res)
            {
                result.append('/');
                result.append(s);
            }
            return result.toString();
        }
    }
    public static void main(String[] args)
	{
		System.out.println(simplifyPath("/.."));
	}
}
