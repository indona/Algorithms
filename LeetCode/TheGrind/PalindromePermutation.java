import java.lang.*;
import java.util.*;

public class PalindromePermutation
{
    public static boolean canPermutePalindrome(String s)
    {
        int[] frequency=new int[256];
        Arrays.fill(frequency, 0);
        for(int i=0;i<s.length();i++)
        {
            frequency[s.charAt(i)-'a']++;
        }
        int oddFrequency=0;
        for(int i=0;i<frequency.length;i++)
        {
            if(frequency[i]%2!=0)
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
