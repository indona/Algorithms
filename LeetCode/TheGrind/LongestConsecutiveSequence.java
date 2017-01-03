import java.lang.*;
import java.util.*;

public class LongestConsecutiveSequence
{
    public static int longestConsecutive(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        Set<Integer> set=new HashSet<Integer>();
        for(int n: nums)
            set.add(n);

        int length=0;
        for(int element: set)
        {
            if(set.contains(element-1))
                continue;
            else
            {
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
