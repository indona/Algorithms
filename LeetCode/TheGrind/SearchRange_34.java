public class SearchRange_34
{
    public static int[] searchRange(int[] nums, int target)
    {
        //The idea behind this problem is to perform a binary search

        int start=0;
        int end=nums.length-1;

        int[] range = {nums.length, -1};
        _searchRange(nums, target, range, start, end);

        if(range[0]>range[1])
            return (new int[]{-1, -1});
        else
            return range;
    }

    public static void _searchRange(int[] nums, int target, int[] range, int start, int end)
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

    public static void main(String args[])
    {
        int[] nums= {1, 4, 7, 7, 7, 7, 7, 7, 9, 11, 13, 19, 19, 19, 21};
        int[] range=new int[2];

        range=searchRange(nums, 19);
        System.out.println("Search term: 19\n"+"Start: "+range[0]+", End: "+range[1]);

        range=searchRange(nums, -7);
        System.out.println("Search term: -7\n"+"Start: "+range[0]+", End: "+range[1]);
    }
}
