public class KthLargestInArray
{
    public static int findKthLargest(int[] nums, int k)
    {
        if(nums==null || nums.length==0 || k<1)
            return 0;

        //Kth largest element in an array = n-k+1
        //Eg. 3 5 1 9 11 6, k=3 (6)
        //=> k'=6-3+1 => 4th element in the sorted array
        return quickSelect(nums, 0, nums.length-1, nums.length-k+1);
    }

    public static int quickSelect(int[] nums, int start, int end, int index)
    {
        int pivot=nums[end];
        int left=start;
        int right=end;

        //Nums=3 9 5 7 1 11 6, k=3, Ans=7
        while(true)
        {
            //If the left elements are already smaller than the pivot, skip
            while(nums[left]<pivot && left<right)
                left++;

            //If the right elements are already greater than/equal to pivot, skip
            while(nums[right]>=pivot && right>left)
                right--;

            //All items are ordered, except the pivot
            if(left==right)
                break;

            //Swap in case of abnormalities
            swap(nums, left, right);
        }
        //Finally swap the pivot into its right place
        swap(nums, left, end);

        //Now check if pivot's position is the desired K. If yes return, else recurse on the appropriate subarray.
        if(index==left+1) //Left+1 : For (n-k+1)th position
            return nums[left];
        else if(index<left+1)
            return quickSelect(nums, start, left-1, index);
        else
            return quickSelect(nums, left+1, end, index);
    }

    public static void swap(int[] nums, int a, int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String args[])
    {
        int[] nums={3, 9, 5, 7, 1, 11, 6};
        int k=3;
        System.out.println(k+"th largest element: "+findKthLargest(nums, k));
    }
}
