import java.lang.*;
import java.util.*;

public class LongestConsecutiveSequence
{
    public static int longestConsecutive(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        //The idea is to process the length of subsequences only trhough the start of a sequence.
        //For this, put the input elements in a set and process each element of the set.
        //For each element: if element-1 exists in the set i.e. if that element is a part of a subsequence, then process the next element.
        //If element-1 does not exist i.e. it is the start of a subarray, then starting from that element scan linearly until you find an element which is not in the set i.e. end of the subsequence. Calculate the length.

        //Put elements into set
        Set<Integer> set=new HashSet<Integer>();
        for(int n: nums)
            set.add(n);

        int length=0;
        //Process each element in a set
        for(int element: set)
        {
            //If element is not the start of the subsequence
            if(set.contains(element-1))
                continue;
            else
            {
                //If element is the start of a subsequence, scan linearly till the end and calculate the length
                int end=0;
                while(set.contains(element))
                {
                    end++;
                    element++;
                }

                length=Math.max(length, end);
            }
        }
        return length;
    }

    public static void main(String args[])
    {
        int[] nums={2,3};
        System.out.println("Longest: "+longestConsecutive(nums));

        int[] nums1={0};
        System.out.println("Longest: "+longestConsecutive(nums1));
    }
}
