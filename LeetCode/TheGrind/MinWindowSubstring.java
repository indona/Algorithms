import java.util.*;

public class MinWindowSubstring
{
    public static String minWindow(String s, String t)
    {
        //The idea behind this problem is to find a window starting from 0th index using left and right pointers.
        //On finding a valid window, we try to shrink the window by incrementing left.
        //If we still have a valid window, we update the minWindowLength.
        //Continue till we miss an element from T. In that case, move right till that element is covered. Check if minWindowLength was reduced further.

        if(s==null || t==null || s.length()==0 || t.length()==0)
            return "";

        //Create the frequency map for T
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        for(char c: t.toCharArray())
        {
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c)+1);
        }

        //Start the window scan
        int left=0, minLeft=0, count=0, minWindowLength=s.length()+1; //count denotes number of characters in T
        for(int right=0;right<s.length();right++)
        {
            char r=s.charAt(right);

            //Check if this char is a part of T. If yes, reduce the frequency of this char.
            //To check if this character is a vlid part of the T we are looking for, we need to check if its updated frequency>=0.
            //If not, that means we are looking at repetitions. If yes, it is a valid part of the T -> so we increment count.
            if(map.containsKey(r))
            {
                map.put(r, map.get(r)-1);
                if(map.get(r)>=0)
                    count++;
            }

            //Now we check if count has reached t.length(). If this window length is smaller that the current, update minWindowLength and minLeft
            while(count==t.length())
            {
                if(minWindowLength > right-left+1)
                {
                    minWindowLength = right-left+1;
                    minLeft = left;
                }
                //Now we increment left and try to shrink the window if possible. If we lose an element from T i.e. the window is no longer valid, we increment right till we find it.
                char l=s.charAt(left);
                if(map.containsKey(l))
                {
                    map.put(l, map.get(l)+1);
                    if(map.get(l)>0) //i.e. our window is now invalid, we need one of this character validate our window
                        count--;
                }
                left++;
            }
        }
        System.out.println("minWindowLength : "+minWindowLength);
        return minWindowLength==(s.length()+1) ? "" : s.substring(minLeft, minLeft+minWindowLength);
    }

    public static void main(String args[])
    {
        String s="ADOBECODEBANC";
        String t="ABC";

        System.out.println("MinWindowSubstring of "+s+" and "+t+" : "+minWindow(s, t));
    }
}
