import java.lang.*;
import java.util.*;

public class LongestCommonPrefix
{
    public static String longestCommonPrefix(String[] strs)
    {
        if(strs==null || strs.length==0)
            return new String("");

        String prefix=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            while(strs[i].indexOf(prefix)!=0)
                prefix=prefix.substring(0, prefix.length()-1);
        }
        return prefix;
    }

    public static void main(String args[])
    {
        String[] strs={"abc", "abcd", "a", "abcabcd"};
        System.out.println("Prefix: "+longestCommonPrefix(strs));
    }
}
