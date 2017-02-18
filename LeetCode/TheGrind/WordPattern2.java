import java.util.*;

public class WordPattern2
{
    public static boolean wordPatternMatch(String pattern, String str)
    {
        //The idea behind this problem is simple backtracking.
        //We start off with trying to match a character in p to a character in s. We store this assignment for reference in the hashmap.
        //We also record the mapping in a set, to avoid re-assignment in O(1) time.
        //If we find any conflict while assigning the mappings, we backtrack and restart from the last valid position.

        Map<Character, String> map=new HashMap<Character, String>();
        Set<String> set=new HashSet<String>();
        return helper(pattern, 0, str, 0, map, set);
    }

    public static boolean helper(String pattern, int pIdx, String str, int sIdx, Map<Character, String> map, Set<String> set)
    {
        //If both are covered, a valid mapping has been found. Return true.
        if(pIdx==pattern.length() && sIdx==str.length())
            return true;

        //If both are not covered, only one of them is covered. Return false.
        if(pIdx==pattern.length() || sIdx==str.length())
            return false;

        //Consider the current character in pattern
        char c=pattern.charAt(pIdx);

        //Check if the pattern exists in the map. If yes, we will find if the previous mapping will apply in this case.
        if(map.containsKey(c))
        {
            String m=map.get(c);

            //If yes, we move ahead, else we backtrack by returning false.
            if(!str.startsWith(m, sIdx))
                return false; //Backtrack
            else
                return helper(pattern, pIdx+1, str, sIdx+m.length(), map, set); //Match ahead
        }

        //If the character is not present in the map, we will assign a new mapping by by trying subsequent character(s) in S.
        for(int i=sIdx;i<str.length();i++)
        {
            String m=str.substring(sIdx, i+1);

            //Before trying this mapping for 'c', we check if the new mapping in already present in the set of mappings.
            //If it exists, we can't use it and try a new mapping by adding one more character to m from s.
            if(set.contains(m))
                continue;

            //Else, we try this mapping.
            map.put(c, m);
            set.add(m);

            //Now we continue to match the rest of the pattern
            if(helper(pattern, pIdx+1, str, sIdx+m.length(), map, set))
                return true;

            //If it doesn't work, we backtrack and remove the mapping from the map and set
            map.remove(c);
            set.remove(m);
        }

        //We have exhausted all options, but still nothing matches
        return false;
    }

    public static void main(String args[])
    {
        String pattern="abab";
        String str="redblueredblue";
        System.out.println("Pattern: "+pattern+", Str: "+str+" => Status: "+wordPatternMatch(pattern, str));

        pattern="aabb";
        str="xyzabcxzyabc";
        System.out.println("Pattern: "+pattern+", Str: "+str+" => Status: "+wordPatternMatch(pattern, str));
    }
}
