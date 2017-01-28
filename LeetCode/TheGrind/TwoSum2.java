import java.util.*;

public class TwoSum2
{
    public static int[] twoSum(int[] nums, int target)
    {
        int[] result=new int[2];

        if(nums==null || nums.length<2)
            return result;

        int left=0, right=nums.length-1;
        while(left<right)
        {
            if(nums[left]+nums[right]==target)
            {
                result[0]=left+1;
                result[1]=right+1;
                break;
            }
            else if(nums[left]+nums[right]>target)
                right--;
            else
                left++;
        }
        return result;
    }

    public static void main(String args[])
    {
        int[] numbers={2, 7, 11, 15};
        int target=9;
        System.out.println("Indices: "+Arrays.toString(twoSum(numbers, target)));
    }
}
