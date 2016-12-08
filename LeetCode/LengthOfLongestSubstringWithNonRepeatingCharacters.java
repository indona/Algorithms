import java.util.*;

public class LengthOfLongestSubstringWithNonRepeatingCharacters
{
    public static int lengthOfLongestSubstring(String s)
    {
        if(s==null || s.length()==0)
            return 0;

        int start=0, end=0, max=0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                start=Math.max(start, map.get(s.charAt(i))+1);
                map.put(s.charAt(i), i);
            }
            else
                map.put(s.charAt(i), i);

            if(i-start+1>max)
              max++;
        }

        return max;
    }

    public static void main(String args[])
    {
        String s = "abcabcbb";
        int max = lengthOfLongestSubstring(s);
        System.out.println("Max substring length: "+ max);
    }
}
