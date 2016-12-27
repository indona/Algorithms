public class SearchInRotatedSortedArray
{
    public static int search(int[] nums, int target)
    {
        int pivot = searchPivot(nums);
        System.out.println("Pivot: "+pivot);

        if(target==nums[pivot])
            return pivot;
        if(target>nums[pivot] && target<=nums[nums.length-1])
            return binarySearch(nums, target, pivot+1, nums.length-1);
        else
            return binarySearch(nums, target, 0, pivot-1);
    }

    public static int searchPivot(int[] nums)
    {
        int start=0;
        int end=nums.length-1;

        while(start<end)
        {
            int mid=(start+end)/2;
            if(nums[mid]<nums[end])
                end=mid;
            else //if(nums[mid]>nums[end])
                start=mid+1;
        }
        return start;
    }

    public static int binarySearch(int[] nums, int target, int start, int end)
    {
        if(start>end)
            return -1;

        int mid=(start+end)/2;
        if(nums[mid]==target)
            return mid;
        else if(target>nums[mid])
            return binarySearch(nums, target, mid+1, end);
        else
            return binarySearch(nums, target, start, mid-1);
    }

    public static void main(String args[])
    {
        int[] nums= new int[] {1, 3};
        int target=3;

        int result=search(nums, target);
        System.out.println("Result: "+result);
    }
}
