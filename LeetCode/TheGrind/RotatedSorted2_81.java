import java.util.*;
import java.lang.*;

public class RotatedSorted2_81
{
    public static boolean search(int[] nums, int target)
    {
        int start=0;
        int end=nums.length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return true;

            // 5 6 7 8 0 1  | 9 1 6 7 8 | 1 1 1 1 0 1
            if(nums[start]<nums[mid])
            {   //pivot is on right
                if(target>nums[mid])
                    start=mid+1;
                else if (target<nums[start])
                    start=mid+1;
                else
                    end=mid-1;
            }
            else if(nums[start]>nums[mid])
            {   //pivot on left
                if(target<nums[mid] || target>nums[end])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else
                start++;
        }

        return false;
    }

    public static void main(String args[])
    {
        int[] nums={1,1,1,1,0,1,6,7,8,19,19,19,20};
        System.out.println("Searching for 19 : "+ search(nums,19));
        System.out.println("Searching for 17 : "+ search(nums,17));
        System.out.println("Searching for 1 : "+ search(nums,1));
    }
}
