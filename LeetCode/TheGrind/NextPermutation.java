import java.lang.*;
import java.util.*;

public class NextPermutation
{
    public static void nextPermutation(int[] nums)
    {
        //Sanity
        if(nums==null || nums.length<=1)
            return;

        //Eg: 456321 Logic: Start from the end and find the first element which is smaller than the previous element i.e. 5
        //Now starting from right, find the first element greater than pivot. i.e. 6
        //Swap the two elements i.e. 465321. Here the two closest and greatest(after the MSB) have been swapped.
        //To make this the next permutation, the rest of the string after 5(pivot1) needs to be reversed i.e. 461235
        int pivot1=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1]) //Find the pivot i.e. the first element from the right which is smaller than its next element.
            {
                pivot1=i;
                break;
            }
        }

        int pivot2=0;
        for(int i=nums.length-1;i>pivot1;i--)
        {
            if(nums[i]>nums[pivot1]) //Find the first element greater than the pivot.
            {
                pivot2=i;
                break;
            }
        }
        if(pivot1==0 && pivot2==0) //The digits are in increasing order
            reverse(nums, 0, nums.length-1);  //Reorder in increasing order and return
        else
        {
            //Swap the pivots
            int temp=nums[pivot1];
            nums[pivot1]=nums[pivot2];
            nums[pivot2]=temp;

            //Reverse the rest of the Arrays starting at Pivot1+1
            reverse(nums, pivot1+1, nums.length-1);
        }
        return;
    }

    public static void reverse(int[] nums, int start, int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;end--;
        }
        return;
    }

    public static void main(String args[])
    {
        int[] nums1={4,5,6,3,2,1};
        System.out.println("Given: "+Arrays.toString(nums1));
        nextPermutation(nums1);
        System.out.println("Next permutation: "+Arrays.toString(nums1));

        int[] nums2={1,1,1,1};
        System.out.println("\nGiven: "+Arrays.toString(nums2));
        nextPermutation(nums2);
        System.out.println("Next permutation: "+Arrays.toString(nums2));

        int[] nums3={};
        System.out.println("\nGiven: "+Arrays.toString(nums3));
        nextPermutation(nums3);
        System.out.println("Next permutation: "+Arrays.toString(nums3));

        int[] nums4={1,3,2};
        System.out.println("\nGiven: "+Arrays.toString(nums4));
        nextPermutation(nums4);
        System.out.println("Next permutation: "+Arrays.toString(nums4));
    }
}
