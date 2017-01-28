public class FirstMissingPositive
{
    public static int firstMissingPositive(int[] nums)
    {
        //The given input comprises of a series of positive numbers with one/more missing number(s). We can have negative numbers too. The list is unordered.
        //Eg. 6, -2, 1, 6, 2, 4 | [7,2,-3,1,5,6,8]
        //The idea is to put the positive numbers in their right place and the one negative number or the next number (in case of all positive) in the missing number's place.
        //To do this, we pick a number and check if it is within the array bounds and check if it{nums[i]} is already in its right place. We do so by checking if nums[i]==nums[nums[i]-1]
        //Finally we do a linear scan to find the first mismatch position and return that.

        for(int i=0;i<nums.length;i++)
        {
            while(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }

    public static void swap(int[] arr, int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String args[])
    {
        int[] nums1={3,4,-1,1};
        int[] nums2={6, -2, 1, 6, 2, 4};

        System.out.println("Missing number: "+firstMissingPositive(nums1));
        System.out.println("Missing number: "+firstMissingPositive(nums2));
    }
}
