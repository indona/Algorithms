import java.util.*;
import java.lang.*;

public class LongestSubstring
{
    public static int lengthOfLongestSubstring(String s)
    {
        //The idea behind this problem is to scan the given string from left. We put the characters in a hashset. When we find a duplicate for the first time, keep track of the length of the substring and its end. Move the start by one and repeat the hashset addition till you find the next duplicate. Update the maxLength and end if you find a bigger substring.
        //A LinkedHashSet is used to maintain the order of insertion.

        if(s==null || s.length()==0)
            return 0;

        Set<Character> set=new LinkedHashSet<Character>();
        int start=0, maxLength=0, maxEnd=0;
        for(int end=0;end<s.length();)
        {
            //duplicate found - See if maxLength changes and update if required. Update the start.
            if(!set.contains(s.charAt(end)))
            {
                set.add(s.charAt(end));
                if((end-start+1)>maxLength)
                {
                    maxLength=Math.max(maxLength, (end-start+1));
                    maxEnd=end;
                }
                //System.out.println("Adding: "+s.charAt(end)+", start: "+start+", MaxLength: "+maxLength+", Maxstart: "+(maxEnd-maxLength+1)+", MaxEnd: "+maxEnd);
                end++;
            }
            else
            {
                Iterator<Character> i=set.iterator();
                set.remove(i.next());
                start++;
                //System.out.println("Removing for adding: "+s.charAt(end));
            }
        }
        System.out.println("Start: "+(maxEnd-maxLength+1)+", End: "+maxEnd);
        return maxLength;
    }

    public static void main(String args[])
    {
        String s="abcaxbcbdabcbb";
        System.out.println("Max length: "+lengthOfLongestSubstring(s));
    }
}
