import java.util.*;
import java.lang.*;

public class ContainsDuplicate2
{
    //The idea is to keep a hashset of size K+1. If we encounter any add error while adding elements into this hashset, yhis means there is some duplicate within the K window.
    //Whenever the size exceeds K+1, remove elements in FIFO order from the set.

    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Set<Integer> set=new HashSet<Integer>();

        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!set.add(nums[i]))
                return true;

            if(set.size()>=k+1)
            {
                set.remove(nums[j]);
                j++;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        int nums[]={10, -12, 3, 4, 5, 4, 3, 10};
        int k=3;
        System.out.println("Status: "+containsNearbyDuplicate(nums, k));
    }
}
