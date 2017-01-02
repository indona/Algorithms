import java.util.*;
import java.lang.*;

public class MaxSumSubArray
{
    public static int maxSubArray(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int[] dpTable=new int[nums.length];
        dpTable[0]=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            dpTable[i]=Math.max(nums[i], dpTable[i-1]+nums[i]);
            max=Math.max(max, dpTable[i]);
        }
        return max;
    }
    public static void main(String args[])
    {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max sum: "+maxSubArray(nums));
    }
}
