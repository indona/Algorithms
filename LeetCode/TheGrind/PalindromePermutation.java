import java.lang.*;
import java.util.*;

public class PalindromePermutation
{
    public static boolean canPermutePalindrome(String s) 
    {
        HashMap<Character, Integer> frequencyMap=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(frequencyMap.containsKey(s.charAt(i)))
                frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i))+1);
            else
                frequencyMap.put(s.charAt(i), 1);
        }

        int oddFrequency=0;
        for(Integer frequency: frequencyMap.values())
        {
            if(frequency%2!=0)
            {
                oddFrequency++;
                if(oddFrequency>1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        System.out.println("String: aaabcca, Status: "+canPermutePalindrome("aaabcca"));
    }
}
