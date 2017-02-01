import java.util.*;

public class MaxSubArrayLen
{
    public static int maxSubArrayLen(int[] nums, int k)
    {
        //The idea behind this problem is to keep a running sum for all elements in the array.
        //A hashtable is used to check if any subarray sats=isfies the given K.
        //For every sum, see if (sum-k) is available in the hashmap. If yes, that means the subarray from (sum-k)th element in the hashmap to the current element adds up to K. Update max according to the max length seen so far.
        if(nums==null || nums.length==0)
            return 0;

        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        int sum=0, max=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if (!map.containsKey(sum))
                map.put(sum, i);

            if(sum==k)
                max=i+1;
            else if(map.containsKey(sum-k))
                max=Math.max(max, i-map.get(sum-k));
        }
        return max;
    }

    public static void main(String rags[])
    {
        int[] nums={1, -1, 5, -2, 3};
        System.out.println("Max: "+maxSubArrayLen(nums, 3));

        int[] nums2={1, 1, 0};
        System.out.println("Max: "+maxSubArrayLen(nums2, 1));
    }
}
