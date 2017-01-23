import java.util.*;
import java.lang.*;

public class LongestSubstring
{
    public static int lengthOfLongestSubstring1(String s)
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

    public static int lengthOfLongestSubstring(String s)
    {
        //The idea behind this problem is to use a hasmap to keep track of the positions of each character in the string.
        //In case of a duplicate, discard all values before the current entry of that character in the hashmap and reset the start to either the next element or the current start, which ever is bigger.
        //Examples: "tmmzuxt" => for the 2nd 'm', start should be resetted to 2. Whereas for the second 't', start should stay at 2 as the index after the position of 1st t (i.e. 1) is smaller than the current start.

        if(s==null || s.length()==0)
            return 0;

        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        int start=0, maxLength=0, maxEnd=0;
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                start=Math.max(map.get(s.charAt(i))+1, start);

            map.put(s.charAt(i), i);
            maxLength=Math.max(maxLength, i-start+1);
        }
        System.out.println("Start: "+start+", End: "+(start+maxLength-1));
        return maxLength;
    }

    public static void main(String args[])
    {
        String s="tmmzuxt";
        System.out.println("Max length: "+lengthOfLongestSubstring(s));
    }
}
