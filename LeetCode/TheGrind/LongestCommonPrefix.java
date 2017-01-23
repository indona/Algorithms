import java.lang.*;
import java.util.*;

public class LongestCommonPrefix
{
    //The idea behind this problem is to start with the first word as the prefix and eliminate parts of the prefix which are not present in the rest of the words.
    //Iterate through rest of the words and check if they start with the current prefix. If not, remove one letter from the prefix and see if this is a valid prefix. Repeat till you find the correct prefix for that word. COntinue for the rest of the words.
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
