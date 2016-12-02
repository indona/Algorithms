import java.util.*;

class SearchRange
{
    public static void searchRange(int[] nums, int target)
    {
        int start=0;
        int end=nums.length-1;

        int[] range = {nums.length, -1};
        _searchRange(nums, target, range, start, end);

        if(range[0]>range[1])
            System.out.println("[-1, -1]");
        else
            System.out.println("["+range[0]+", "+range[1]+"]");
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
        Scanner scanner = new Scanner(System.in);

        int T=scanner.nextInt();

        for(int i=0;i<T;i++)
        {
            int N=scanner.nextInt();
            int[] inputArray=new int[N];
            for(int j=0;j<N;j++)
            {
                inputArray[j]=scanner.nextInt();
            }
            int target=scanner.nextInt();
            searchRange(inputArray, target);
        }
    }
}
