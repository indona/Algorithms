public class SearchRange 
{
    public int[] searchRange(int[] nums, int target)
    {
        int start=0;
        int end=nums.length-1;

        int[] range = {nums.length, -1};
        _searchRange(nums, target, range, start, end);

        if(range[0]>range[1])
            return (new int[]{-1, -1});
        else
            return range;
    }

    public void _searchRange(int[] nums, int target, int[] range, int start, int end)
    {
        int mid=(start+end)/2;
        if(start<=end)
        {
            if(nums[mid]>target)
                _searchRange(nums, target, range, start, mid-1);
            else if (nums[mid]<target)
                _searchRange(nums, target, range, mid+1, end);
            else //equal
            {
                if(mid<range[0])
                {
                    range[0]=mid;
                    _searchRange(nums, target, range, start, mid-1);
                }
                if(mid>range[1])
                {
                    range[1]=mid;
                    _searchRange(nums, target, range, mid+1, end);
                }
            }
        }
        else return;
    }
}
