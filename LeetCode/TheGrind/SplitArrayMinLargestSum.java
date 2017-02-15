import java.util.*;

public class SplitArrayMinLargestSum
{
    public static int splitArray(int[] nums, int m)
    {
        /*
        The idea behind this problem is to use binary search to find the minimum array sum which can be achieved by dividing the given elements into m groups.
        The ans lies between the max element in the array and the sum of array - the initial bounds for the binary search.
        For each mid, we try to divide the given array into M subarrays with their individual sums less than mid - done using canDivide()
        If it returns true: means either we were not able to make m groups (ran out of numbers) or we were able to divide into M groups but the sum of each group is less than mid. In both cases, we need to consider a smaller mid. So right=mid-1.
        If it returns false: We have numbers left after making M groups i.e. our mid was too small. We need to increase mid.
        So left=mid+1
        */

        int max=0;
        long sum=0;

        for(int num: nums)
        {
            max=Math.max(max, num);
            sum+=num;
        }

        if (m==1)
            return (int)sum;

        long left=max, right=sum;
        while(left<=right)
        {
            long mid=(left+right)/2;

            //Can divide. But we need to find the min one. So move right to mid-1.
            if(canDivide(mid, nums, m))
                right=mid-1;
            //Cannot divide. Number of groups > M. Increase the left boundary to left=mid+1.
            else
                left=mid+1;
        }
        return (int)left;
    }

    public static boolean canDivide(long currentMid, int[] nums, int m)
    {
        int numSubArrays=1;
        long subArraySum=0;

        for(int num: nums)
        {
            subArraySum+=num; //Keep a running sum for each subarray

            if(subArraySum>currentMid)
            {
                //The moment subArraySum exceeds currentMid, cut this subarray off and start a new one with running sum=num.
                subArraySum=num;
                numSubArrays++;

                //If the number of subarrays>m, return false (mid too small)
                if(numSubArrays>m)
                    return false;
            }
        }
        //If the division worked out, we need to try out a smaller mid. SO return true;
        return true;
    }

    public static void main(String args[])
    {
        int[] nums={7,2,5,10,8,16,1};
        int m=4;
        System.out.println("Min largest sum for "+Arrays.toString(nums)+" and m="+m+" : "+splitArray(nums, m));
    }
}
