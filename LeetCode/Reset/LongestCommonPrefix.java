import java.util.*;

public class LongestCommonPrefix
{
    public static String longestCommonPrefix(String[] strs)
    {
        if(strs==null || strs.length==0)
            return "";

        Arrays.sort(strs);

        int i=0;
        StringBuilder prefix=new StringBuilder();

        for(char c: strs[0].toCharArray())
        {
            for(String str : strs)
            {
                if(str.charAt(i)!=c)
                    return prefix.toString();
            }
            prefix.append(c);
            i++;
        }
        return prefix.toString();
    }

    public static void main(String args[])
    {
        String[] strs = {"Abcd", "Abcxyz", "Acz"};
        String prefix = longestCommonPrefix(strs);

        System.out.println("Prefix: "+prefix);
    }
}
